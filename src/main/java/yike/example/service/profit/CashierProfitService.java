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
import yike.example.service.rule.BaseCashierRuleService;

/**
 * 规则 现金立减 <br>
 * 
 * @author Administrator
 *
 */
@Service
public class CashierProfitService extends BaseCashierRuleService implements IPromotionRuleProfitService {

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
		Long promotionValue = jsonObject.getLong("promotionValue");//减多少钱
		String promotionDesc = jsonObject.getString("desc");
		
		//这里根据单价进行平均分配
		Long totalPrice = 0L;
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			totalPrice += cartStockDTO.getShoppingCount() * cartStockDTO.getPrice();
		}
		Long avgPromotionValuePer = promotionValue/totalPrice;
		
		Long totalDeduct = 0L;
		int i = 0;
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
//			if (i == cartStockDTOs.size() - 1) {
//				//最后一个 为平均+最后优惠值
//				if (cartStockDTO.getShoppingCount() > 1) {
//					Long deductPrice = cartStockDTO.getPrice() - avgPromotionValue;
//					Long totalProfitPrice = avgPromotionValue * cartStockDTO.getShoppingCount();
//					
//					PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), deductPrice, cartStockDTO.getShoppingCount().intValue(), totalProfitPrice,
//							promotionId, promotionDesc);
//					deducts.add(promotionProfitStockItemDeduct);
//					totalDeduct += totalProfitPrice;
//				} else {
//					Long deductPrice = promotionValue - ;
//					Long totalProfitPrice = avgPromotionValue * cartStockDTO.getShoppingCount();
//					
//					PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), deductPrice, cartStockDTO.getShoppingCount().intValue(), totalProfitPrice,
//							promotionId, promotionDesc);
//					deducts.add(promotionProfitStockItemDeduct);
//					totalDeduct += totalProfitPrice;
//				}
//				
//			} else {
//				//前面的都平均
//				Long deductPrice = cartStockDTO.getPrice() - avgPromotionValue;
//				Long totalProfitPrice = avgPromotionValue * cartStockDTO.getShoppingCount();
//				
//				PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(cartStockDTO.getId(), cartStockDTO.getPrice(), deductPrice, cartStockDTO.getShoppingCount().intValue(), totalProfitPrice,
//						promotionId, promotionDesc);
//				deducts.add(promotionProfitStockItemDeduct);
//				totalDeduct += totalProfitPrice;
//			}
		}
		
		profitStockItem.setTotalDeduct(totalDeduct);
		
		return promotionProfitBO;
	}

}
