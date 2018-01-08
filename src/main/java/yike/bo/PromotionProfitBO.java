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
	private List<PromotionProfitStockItem> stockItems;
	
	/**
	 * 其他可选优惠
	 */
	private List<PromotionProfitBO> alternativeProfit;

	public List<PromotionProfitReward> getRewards() {
		return rewards;
	}

	public void setRewards(List<PromotionProfitReward> rewards) {
		this.rewards = rewards;
	}

	public PromotionProfitPostFee getPromotionProfitPostFee() {
		return promotionProfitPostFee;
	}

	public void setPromotionProfitPostFee(PromotionProfitPostFee promotionProfitPostFee) {
		this.promotionProfitPostFee = promotionProfitPostFee;
	}

	public List<PromotionProfitBO> getAlternativeProfit() {
		return alternativeProfit;
	}

	public void setAlternativeProfit(List<PromotionProfitBO> alternativeProfit) {
		this.alternativeProfit = alternativeProfit;
	}

	public List<PromotionProfitStockItem> getStockItems() {
		return stockItems;
	}

	public void setStockItems(List<PromotionProfitStockItem> stockItems) {
		this.stockItems = stockItems;
	}
	
	
}
