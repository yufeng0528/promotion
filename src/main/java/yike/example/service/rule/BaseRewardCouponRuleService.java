package yike.example.service.rule;

import yike.example.constants.PromotionConstants;
import yike.example.service.IPromotionRuleService;

public class BaseRewardCouponRuleService implements IPromotionRuleService {

	@Override
	public String promotionRuleType() {
		return PromotionConstants.PROMOTION_RULE_TYPE_REWARD + "_" + PromotionConstants.PROMOTION_RULE_SUBTYPE_REWARD_COUPON;
	}

}
