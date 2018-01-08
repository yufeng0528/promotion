package yike.example.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import yike.example.mapper.PromotionRuleProfitMapper;
import yike.example.obj.PromotionRuleProfit;
import yike.example.obj.PromotionRuleProfitCriteria;

@Component
public class PromotionRuleProfitDao {

	@Resource
	private PromotionRuleProfitMapper promotionRuleProfitMapper;
	
	public List<PromotionRuleProfit> selectList(Long supplierId, Long promotionId, Long promotionRuleConditionId) {
		PromotionRuleProfitCriteria criteria = new PromotionRuleProfitCriteria();
		PromotionRuleProfitCriteria.Criteria criteriaInternal = criteria.createCriteria();
		criteriaInternal.andSupplierIdEqualTo(supplierId).andPromotionIdEqualTo(promotionId)
			.andPromotionRuleConditionIdEqualTo(promotionRuleConditionId);
		return promotionRuleProfitMapper.selectByExample(criteria);
	}
}
