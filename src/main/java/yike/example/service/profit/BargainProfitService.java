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
import yike.example.exception.IllegalBizException;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BaseBargainRuleService;

/**
 * 支持规则<br>
 * 达到砍价人数后，可以用指定价格购买1个指定SKU
 * 如果有两个SKU都达成，则会生成两条记录
 * @author Administrator
 *
 */
@Service
public class BargainProfitService extends BaseBargainRuleService implements IPromotionRuleProfitService {
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		if (cartStockDTOs.size() != 1) {
			throw new IllegalBizException("砍价对应SKU只能有一个");
		}
		
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		PromotionProfitStockItem profitStockItem = new PromotionProfitStockItem();
		List<PromotionProfitStockItemDeduct> deducts = new ArrayList<>();
		profitStockItem.setList(deducts);
		List<PromotionProfitStockItem> promotionProfitStockItems = new ArrayList<>();
		promotionProfitStockItems.add(profitStockItem);
		promotionProfitBO.setStockItems(promotionProfitStockItems);
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleBo.getPromotionRuleProfit();
		
		Long totalDeduct = 0L;
		CartStockDTO cartStockDTO = cartStockDTOs.get(0);
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");
		String promotionDesc = "砍价优惠价-" + new BigDecimal(1.0 * promotionValue / 100).setScale(2, RoundingMode.HALF_UP).toString() + "元";
		Long totalProfitPrice = cartStockDTO.getPrice() - promotionValue;
		PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), promotionValue, 1, totalProfitPrice,
				promotionId, promotionDesc);
		deducts.add(promotionProfitStockItemDeduct);
		totalDeduct += promotionValue;
		profitStockItem.setTotalDeduct(totalDeduct);
		
		return promotionProfitBO;
	}

}
