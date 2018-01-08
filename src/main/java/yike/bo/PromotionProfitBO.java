package yike.bo;

import java.util.List;

public class PromotionProfitBO {

	/**
	 * 是否享受包邮优惠
	 */
	private PromotionProfitPostFee promotionProfitPostFee;
	
	/**
	 * 享受的赠品或者服务
	 */
	private List<PromotionProfitReward> rewards;
	
	/**
	 * 价格上的优惠
	 */
	private List<PromotionProfitStockItemDeduct> stockItemDeducts;

	public List<PromotionProfitReward> getRewards() {
		return rewards;
	}

	public void setRewards(List<PromotionProfitReward> rewards) {
		this.rewards = rewards;
	}

	public List<PromotionProfitStockItemDeduct> getStockItemDeducts() {
		return stockItemDeducts;
	}

	public void setStockItemDeducts(List<PromotionProfitStockItemDeduct> stockItemDeducts) {
		this.stockItemDeducts = stockItemDeducts;
	}

	public PromotionProfitPostFee getPromotionProfitPostFee() {
		return promotionProfitPostFee;
	}

	public void setPromotionProfitPostFee(PromotionProfitPostFee promotionProfitPostFee) {
		this.promotionProfitPostFee = promotionProfitPostFee;
	}
	
	
}
