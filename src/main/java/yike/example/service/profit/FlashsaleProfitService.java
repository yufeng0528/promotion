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
		if (cartStockDTOs.size() != 1) {
			throw new IllegalBizException("闪购只支持一种商品");
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
		String promotionDesc = "闪购优惠价-" + new BigDecimal(1.0 * promotionValue / 100).setScale(2, RoundingMode.HALF_UP).toString() + "元";
		Long totalProfitPrice = cartStockDTO.getPrice() - promotionValue;
		PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), promotionValue, cartStockDTO.getShoppingCount().intValue(), totalProfitPrice,
				promotionId, promotionDesc);
		deducts.add(promotionProfitStockItemDeduct);
		totalDeduct += promotionValue;
		profitStockItem.setTotalDeduct(totalDeduct);
		
		return promotionProfitBO;
	}

}
