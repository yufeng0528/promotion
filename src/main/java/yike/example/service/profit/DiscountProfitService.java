package yike.example.service.profit;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitStockItemDeduct;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BaseDiscountRuleService;

/**
 * 对满足条件的所有商品打折
 * @author Administrator
 *
 */
@Service
public class DiscountProfitService extends BaseDiscountRuleService implements IPromotionRuleProfitService {

	private static Logger logger = LoggerFactory.getLogger(DiscountProfitService.class);
	
	@Resource
	private ProfitCompareService profitCompareService;
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleBo.getPromotionRuleProfit();
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");//打折
		
		Long totalDeduct = 0L;
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			Long deductPrice = cartStockDTO.getPrice() * promotionValue / 100;
			Long totalProfitPrice = (cartStockDTO.getPrice() - deductPrice) * cartStockDTO.getShoppingCount();
			totalDeduct += totalProfitPrice;
		}
		
		logger.info("开始检查优惠冲突 this:" + promotionId);
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			if (!profitCompareService.checkGroupPromotion(cartStockDTO, totalDeduct)) {
				return null;
			}
		}
		
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			String promotionDesc = "折扣-" + promotionValue + "折";
			Long deductPrice = cartStockDTO.getPrice() * promotionValue / 100;
			Long totalProfitPrice = (cartStockDTO.getPrice() - deductPrice) * cartStockDTO.getShoppingCount();
			
			PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
			PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(totalProfitPrice,
					promotionId, promotionDesc);
			promotionProfitBO.setPromotionProfitStockItemDeduct(promotionProfitStockItemDeduct);
			cartStockDTO.setGroupPromotion(promotionProfitBO);
		}
		
		return null;
	}

}
