package yike.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.exception.IllegalDatabaseFormatException;
import yike.example.obj.PromotionRuleCondition;

@Service
public class PromotionRuleConditionService {

	private static Logger logger = LoggerFactory.getLogger(PromotionRuleConditionService.class);
	
	/**
	 * 按照促销条件筛选
	 * @param rules
	 * @return
	 */
	public Map<PromotionRuleBO, List<CartStockDTO>> filterByCondition(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		logger.info("开始进行促销条件筛选");
		Set<PromotionRuleBO> rules = promotionContext.keySet();
		if (CollectionUtils.isEmpty(promotionContext.keySet())) {
			return null;
		}
		
		Map<PromotionRuleBO, List<CartStockDTO>> newPromotionContext = new HashMap<>(rules.size());
		for (PromotionRuleBO promotionRuleBO : rules) {
			List<CartStockDTO> cartStocks = promotionContext.get(promotionRuleBO);
			if (filterAndSetLevel(promotionRuleBO, cartStocks)) {
				newPromotionContext.put(promotionRuleBO, cartStocks);
			}
		}
		logger.info("结束促销条件筛选");
		return newPromotionContext;
	}
	
	private boolean filterAndSetLevel(PromotionRuleBO promotionRuleBO, List<CartStockDTO> cartStocks) {
		List<PromotionRuleCondition> conditions = promotionRuleBO.getRuleConditions();
		if (CollectionUtils.isEmpty(conditions)) {
			throw new IllegalDatabaseFormatException("promotion_rule_condition数据缺失", "至少要有一条默认数据");
		}
		
		long totalAmount = 0L;
		int count = 0;
		
		for (CartStockDTO cartStockDTO : cartStocks) {
			count += cartStockDTO.getShoppingCount();
			totalAmount += cartStockDTO.getPrice() * cartStockDTO.getShoppingCount();
		}
		
		boolean filter = false;
		int level = 0;
		for (PromotionRuleCondition promotionRuleCondition : conditions) {
			//两个条件是与的关系，如果想要达到或的关系可以把另外个条件设置成0
			if (promotionRuleCondition.getAmount() > totalAmount && promotionRuleCondition.getCount() > count) {
				filter = true;
				logger.info("-- 通过规则 :" + promotionRuleBO.getPromotionRule().getId() + " level:" + level);
				promotionRuleBO.setLevel(level);
			} else {
				break;
			}
		}
		
		return filter;
	}
}
