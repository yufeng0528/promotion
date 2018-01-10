package yike.example.service.rule;

import yike.example.constants.PromotionConstants;
import yike.example.service.IPromotionRuleService;

public class BaseDiscountRuleService implements IPromotionRuleService {

	@Override
	public String promotionRuleType() {
		return PromotionConstants.PROMOTION_RULE_TYPE_DISCOUNT + "_" + PromotionConstants.PROMOTION_RULE_SUBTYPE_DISCOUNT_NORMAL;
	}

}
