package yike.bo;

public class PromotionProfitStockItemDeduct {

	/**
	 * 总优惠
	 */
	private Long totalProfitPrice;
	
	private Long promotionId;
	
	private String promotionDesc;
	
	public PromotionProfitStockItemDeduct(){}
	
	public PromotionProfitStockItemDeduct(Long totalProfitPrice, Long promotionId, String promotionDesc) {
		this.totalProfitPrice = totalProfitPrice;
		this.promotionId = promotionId;
		this.promotionDesc = promotionDesc;
	}

	public Long getTotalProfitPrice() {
		return totalProfitPrice;
	}

	public void setTotalProfitPrice(Long totalProfitPrice) {
		this.totalProfitPrice = totalProfitPrice;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionDesc() {
		return promotionDesc;
	}

	public void setPromotionDesc(String promotionDesc) {
		this.promotionDesc = promotionDesc;
	}

}
