package yike.bo;

import java.util.List;

/**
 * 赠品优惠
 * @author Administrator
 *
 */
public class PromotionProfitReward {

	private Long promotionId;
	
	/**
	 * 优惠子类型
	 */
	private Integer promotionRuleSubType;
	
	/**
	 * 优惠描述
	 */
	private String rewardDesc;
	
	/**
	 * 关联的具体优惠
	 */
	private List<Long> referIds;
	
	/**
	 * 总优惠
	 */
	private Long totalProfitPrice;
	
	public PromotionProfitReward(){}
	
	public PromotionProfitReward(Long promotionId, Long totalProfitPrice, Integer promotionRuleSubType, String rewardDesc) {
		this.promotionId = promotionId;
		this.promotionRuleSubType = promotionRuleSubType;
		this.rewardDesc = rewardDesc;
		this.setTotalProfitPrice(totalProfitPrice);
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public Integer getPromotionRuleSubType() {
		return promotionRuleSubType;
	}

	public void setPromotionRuleSubType(Integer promotionRuleSubType) {
		this.promotionRuleSubType = promotionRuleSubType;
	}

	public String getRewardDesc() {
		return rewardDesc;
	}

	public void setRewardDesc(String rewardDesc) {
		this.rewardDesc = rewardDesc;
	}

	public List<Long> getReferIds() {
		return referIds;
	}

	public void setReferIds(List<Long> referIds) {
		this.referIds = referIds;
	}

	public Long getTotalProfitPrice() {
		return totalProfitPrice;
	}

	public void setTotalProfitPrice(Long totalProfitPrice) {
		this.totalProfitPrice = totalProfitPrice;
	}
	
	
}
