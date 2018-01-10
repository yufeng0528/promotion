package yike.example.service.profit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitStockItem;
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

	@Resource
	private PromotionRuleProfitService promotionRuleProfitService;
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		PromotionProfitStockItem profitStockItem = new PromotionProfitStockItem();
		List<PromotionProfitStockItemDeduct> deducts = new ArrayList<>();
		profitStockItem.setList(deducts);
		List<PromotionProfitStockItem> promotionProfitStockItems = new ArrayList<>();
		promotionProfitStockItems.add(profitStockItem);
		promotionProfitBO.setStockItems(promotionProfitStockItems);
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleProfitService.getByPromotionId(promotionRuleBo.getPromotionRule().getSupplierId(), promotionRuleBo.getPromotionRule().getPromotionId(), promotionRuleBo.getLevel());
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");//打折
		
		Long totalDeduct = 0L;
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			String promotionDesc = "折扣-" + promotionValue + "折";
			Long deductPrice = cartStockDTO.getPrice() * promotionValue / 100;
			Long totalProfitPrice = (cartStockDTO.getPrice() - deductPrice) * cartStockDTO.getShoppingCount();
			
			PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), deductPrice, cartStockDTO.getShoppingCount().intValue(), totalProfitPrice,
					promotionId, promotionDesc);
			deducts.add(promotionProfitStockItemDeduct);
			totalDeduct += totalProfitPrice;
		}
		
		profitStockItem.setTotalDeduct(totalDeduct);
		
		return promotionProfitBO;
	}

}
