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
import yike.example.service.rule.BaseCashierRuleService;

/**
 * 规则 现金立减 <br>
 * 可以是订单优惠也可以是组合优惠
 * @author Administrator
 *
 */
@Service
public class CashierProfitService extends BaseCashierRuleService implements IPromotionRuleProfitService {

	private static Logger logger = LoggerFactory.getLogger(CashierProfitService.class);
	
	@Resource
	private ProfitCompareService profitCompareService;
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleBo.getPromotionRuleProfit();
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		Long promotionValue = jsonObject.getLong("promotionValue");//减多少钱
		String promotionDesc = jsonObject.getString("desc");
		
		logger.info("开始检查优惠冲突 this:" + promotionId);
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			//要根据优先级判断是检查group还是order
			if (!profitCompareService.checkGroupPromotion(cartStockDTO, promotionValue)) {
				return null;
			}
		}
		
		//这里根据单价进行平均分配
		Long totalPrice = 0L;
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			totalPrice += cartStockDTO.getShoppingCount() * cartStockDTO.getPrice();
		}
		//最多总价
		if (promotionValue > totalPrice) {
			promotionValue = totalPrice;
		}
		
		Long totalDeduct = 0L;
		int i = 0;
		
		for (CartStockDTO cartStockDTO : cartStockDTOs) {
			PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
			
			if (i == cartStockDTOs.size() - 1) {
				Long totalProfitPrice = promotionValue - totalDeduct;
				
				PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(totalProfitPrice,
						promotionId, promotionDesc);
				promotionProfitBO.setPromotionProfitStockItemDeduct(promotionProfitStockItemDeduct);
				
			} else {
				//前面的都平均
				Long totalProfitPrice = (long) (1.0 * cartStockDTO.getShoppingCount() * cartStockDTO.getPrice() / totalPrice * promotionValue);
				
				PromotionProfitStockItemDeduct promotionProfitStockItemDeduct = new PromotionProfitStockItemDeduct(totalProfitPrice,
						promotionId, promotionDesc);
				promotionProfitBO.setPromotionProfitStockItemDeduct(promotionProfitStockItemDeduct);
				totalDeduct += totalProfitPrice;
			}
			
			cartStockDTO.setGroupPromotion(promotionProfitBO);
		}
		
		
		return null;
	}
	
}
