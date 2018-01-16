package yike.example.service.profit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitStockItemDeduct;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BaseFlashsaleRuleService;

/**
 * 规则<br>
 * 在规定时间内抢到特价商品，支持限购多个
 * @author Administrator
 *
 */
@Service
public class FlashsaleProfitService extends BaseFlashsaleRuleService implements IPromotionRuleProfitService {

	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
//		if (cartStockDTOs.size() != 1) {
//			throw new IllegalBizException("闪购只支持一种商品");
//		}
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleBo.getPromotionRuleProfit();
		
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");
		String promotionDesc = "闪购优惠价-" + new BigDecimal(1.0 * promotionValue / 100).setScale(2, RoundingMode.HALF_UP).toString() + "元";
		
		int size = 1;//这应该从数据库读取
		
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			Long totalProfitPrice = 0L;
			if (cartStockDTO.getShoppingCount() <= size) {
				totalProfitPrice = cartStockDTO.getShoppingCount() * (promotionValue - cartStockDTO.getPrice());
			} else {
				totalProfitPrice = size * (promotionValue - cartStockDTO.getPrice());
			} 
			PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
			PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(totalProfitPrice, promotionId, promotionDesc);
			promotionProfitBO.setPromotionProfitStockItemDeduct(promotionProfitStockItemDeduct);
			
			if (cartStockDTO.getSpecialPromotion() == null) {
				cartStockDTO.setSpecialPromotion(promotionProfitBO);
			} else {
				PromotionProfitBO lastPromotion = cartStockDTO.getSpecialPromotion();//取最优
				if (lastPromotion.getPromotionProfitStockItemDeduct().getTotalProfitPrice() < totalProfitPrice) {
					cartStockDTO.setSpecialPromotion(promotionProfitBO);
				}
			}
		}
		
		return null;
	}

}
