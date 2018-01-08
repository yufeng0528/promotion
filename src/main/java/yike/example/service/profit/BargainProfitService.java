package yike.example.service.profit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitStockItem;
import yike.bo.PromotionProfitStockItemDeduct;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BaseBargainRuleService;

@Service
public class BargainProfitService extends BaseBargainRuleService implements IPromotionRuleProfitService {
	
	private PromotionRuleProfitService promotionRuleProfitService;

	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		PromotionProfitStockItem profitStockItem = new PromotionProfitStockItem();
		List<PromotionProfitStockItemDeduct> deducts = new ArrayList<>();
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleProfitService.getByPromotionId(promotionRuleBo.getPromotionRule().getSupplierId(), promotionRuleBo.getPromotionRule().getPromotionId(), promotionRuleBo.getLevel());
		
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
			Long promotionValue = jsonObject.getLong("promotionValue");
			String promotionDesc = "砍价优惠价-" + new BigDecimal(1.0*promotionValue/100).setScale(2, RoundingMode.HALF_UP).toString() + "元";
			Long totalProfitPrice = promotionValue;
			PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), promotionValue, totalProfitPrice, promotionId, promotionDesc);
		}
		return null;
	}

}
