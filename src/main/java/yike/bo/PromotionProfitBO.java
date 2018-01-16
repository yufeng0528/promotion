package yike.bo;

public class PromotionProfitBO {

//	/**
//	 * 是否享受包邮优惠
//	 */
//	private PromotionProfitPostFee promotionProfitPostFee;
	
	/**
	 * 享受的赠品或者服务
	 */
	private PromotionProfitReward reward;
	
//	/**
//	 * 价格上的优惠
//	 */
//	private List<PromotionProfitStockItem> stockItems;
//	
//	/**
//	 * 其他可选优惠
//	 */
//	private List<PromotionProfitBO> alternativeProfit;
	
	/**
	 * 价格上的优惠
	 */
	private PromotionProfitStockItemDeduct promotionProfitStockItemDeduct;

	public PromotionProfitStockItemDeduct getPromotionProfitStockItemDeduct() {
		return promotionProfitStockItemDeduct;
	}

	public void setPromotionProfitStockItemDeduct(PromotionProfitStockItemDeduct promotionProfitStockItemDeduct) {
		this.promotionProfitStockItemDeduct = promotionProfitStockItemDeduct;
	}

	public PromotionProfitReward getReward() {
		return reward;
	}

	public void setReward(PromotionProfitReward reward) {
		this.reward = reward;
	}
	
	
}
