package yike.bo;

public class PromotionProfitStockItemDeduct {

	/**
	 * 购物车id
	 */
	private Long id;
	
	/**
	 * 优惠了多少钱
	 */
	private Long deductPrice;
	
	/**
	 * 有几个享受了优惠
	 */
	private Integer shoppingCount;
	
	/**
	 * 总优惠
	 */
	private Long totalProfitPrice;
	
	private Long promotionId;
	
	private String promotionDesc;
	
	public PromotionProfitStockItemDeduct(){}
	
	public PromotionProfitStockItemDeduct(Long id, Long oldPrice, Long deductPrice, Integer shoppingCount, Long totalProfitPrice, Long promotionId, String promotionDesc) {
		this.id = id;
		this.deductPrice = deductPrice;
		this.totalProfitPrice = totalProfitPrice;
		this.promotionId = promotionId;
		this.promotionDesc = promotionDesc;
		this.shoppingCount = shoppingCount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeductPrice() {
		return deductPrice;
	}

	public void setDeductPrice(Long deductPrice) {
		this.deductPrice = deductPrice;
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

	public Integer getShoppingCount() {
		return shoppingCount;
	}

	public void setShoppingCount(Integer shoppingCount) {
		this.shoppingCount = shoppingCount;
	}
	
	
}
