package yike.example.service.profit;

import java.util.List;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.service.IPromotionRuleService;

public interface IPromotionRuleProfitService extends IPromotionRuleService {

	/**
	 * 处理优惠
	 * @param promotionRuleBo	优惠规则
	 * @param cartStockDTOs
	 * @return true达成优惠 false没有
	 */
	PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs);
}
