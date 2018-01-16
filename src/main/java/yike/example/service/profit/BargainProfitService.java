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
import yike.example.service.rule.BaseBargainRuleService;

/**
 * 支持规则<br>
 * 达到砍价人数后，可以用指定价格购买N个指定SKU
 * 如果有两个SKU都达成，则会生成一条记录
 * @author Administrator
 *
 */
@Service
public class BargainProfitService extends BaseBargainRuleService implements IPromotionRuleProfitService {
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
//		if (cartStockDTOs.size() != 1) {
//			throw new IllegalBizException("砍价对应SKU只能有一个");
//		}
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleBo.getPromotionRuleProfit();
		
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");
		String promotionDesc = "砍价优惠价-" + new BigDecimal(1.0 * promotionValue / 100).setScale(2, RoundingMode.HALF_UP).toString() + "元";
		
		int size = 2;//这应该从数据库读取
		
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
