package yike.example.service.rule;

import yike.example.constants.PromotionConstants;
import yike.example.service.IPromotionRuleService;

public class BaseBargainRuleService implements IPromotionRuleService {

	@Override
	public String promotionRuleType() {
		return PromotionConstants.PROMOTION_RULE_TYPE_SPECIAL + "_" + PromotionConstants.PROMOTION_RULE_SUBTYPE_SPECIAL_BARGIAN;
	}
	
}
