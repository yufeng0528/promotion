package yike.example.constants;

public class PromotionConstants {

	/**
	 * 赠品
	 */
	public static byte PROMOTION_RULE_TYPE_REWARD = 0;
	
	/**
	 * 打折
	 */
	public static byte PROMOTION_RULE_TYPE_DISCOUNT = 1;
	
	/**
	 * 立减
	 */
	public static byte PROMOTION_RULE_TYPE_CASHIER = 2;
	
	/**
	 * 特价
	 */
	public static byte PROMOTION_RULE_TYPE_SPECIAL = 3;
	
	/**
	 * 包邮
	 */
	public static byte PROMOTION_RULE_TYPE_FREE_POSTFEE = 4;
	
	
	/**
	 * 闪购
	 */
	public static byte PROMOTION_RULE_SUBTYPE_SPECIAL_FLASHSALE = 0;
	
	/**
	 * 砍价
	 */
	public static byte PROMOTION_RULE_SUBTYPE_SPECIAL_BARGIAN = 1;
	
	/**
	 * 送优惠券
	 */
	public static byte PROMOTION_RULE_SUBTYPE_REWARD_COUPON = 0;
	
	public static byte PROMOTION_RULE_SUBTYPE_DISCOUNT_NORMAL = 0;
	
	public static int PROMOTION_PRIORITY_EXCLUDE = 0;
	
}
