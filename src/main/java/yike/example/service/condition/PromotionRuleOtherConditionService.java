package yike.example.service.condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import yike.bo.PromotionContext;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;

@Service
public class PromotionRuleOtherConditionService {

	private static Logger logger = LoggerFactory.getLogger(PromotionRuleOtherConditionService.class);
	
	@Resource
	private PromotionRuleOtherConditionServiceFactory otherConditionServiceFactory;
	
	/**
	 * 按照促销条件筛选
	 * @param rules
	 * @return
	 */
	public Map<PromotionRuleBO, List<CartStockDTO>> filterByCondition(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		logger.info("开始进行其他规则筛选");
		Set<PromotionRuleBO> rules = promotionContext.keySet();
		if (CollectionUtils.isEmpty(promotionContext.keySet())) {
			return null;
		}
		
		Map<PromotionRuleBO, List<CartStockDTO>> newPromotionContext = new HashMap<>(rules.size());
		for (PromotionRuleBO promotionRuleBO : rules) {
			IPromotionRuleOtherService iPromotionRuleOtherService = otherConditionServiceFactory.getRuleOtherService(promotionRuleBO.getPromotionRule().getType());
			if (iPromotionRuleOtherService != null) {
				boolean pass = iPromotionRuleOtherService.filterByOtherRule(promotionRuleBO, PromotionContext.getCartCustomer(), promotionContext.get(promotionContext));
				if (pass) {
					newPromotionContext.put(promotionRuleBO, promotionContext.get(promotionContext));
				}
			}
		}
		logger.info("结束其他规则筛选");
		return newPromotionContext;
	}
}
