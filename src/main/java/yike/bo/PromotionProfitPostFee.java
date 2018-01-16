package yike.bo;

public class PromotionProfitPostFee {

	private Long promotionId;
	
	private String promotionDesc;
	
	private Long totalProfitPrice;

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

	public Long getTotalProfitPrice() {
		return totalProfitPrice;
	}

	public void setTotalProfitPrice(Long totalProfitPrice) {
		this.totalProfitPrice = totalProfitPrice;
	}
	
}
