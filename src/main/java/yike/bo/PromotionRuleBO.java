package yike.bo;

import java.util.List;

import yike.example.obj.PromotionRule;
import yike.example.obj.PromotionRuleCondition;

public class PromotionRuleBO {

	private PromotionRule promotionRule;
	
	private List<PromotionRuleCondition> ruleConditions;
	
	private Integer priority;
	
	private Integer level;
	
	

	public PromotionRule getPromotionRule() {
		return promotionRule;
	}

	public void setPromotionRule(PromotionRule promotionRule) {
		this.promotionRule = promotionRule;
	}

	public List<PromotionRuleCondition> getRuleConditions() {
		return ruleConditions;
	}

	public void setRuleConditions(List<PromotionRuleCondition> ruleConditions) {
		this.ruleConditions = ruleConditions;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
}
