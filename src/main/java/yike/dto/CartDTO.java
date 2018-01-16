package yike.dto;

import java.util.List;

import yike.bo.PromotionProfitPostFee;

public class CartDTO {

	private List<CartStockDTO> cartStocks;
	
	/**
	 * 邮费
	 */
	private Long postFee;
	
	/**
	 * 是否包邮
	 */
	private PromotionProfitPostFee promotionProfitPostFee;

	public List<CartStockDTO> getCartStocks() {
		return cartStocks;
	}

	public void setCartStocks(List<CartStockDTO> cartStocks) {
		this.cartStocks = cartStocks;
	}

	public Long getPostFee() {
		return postFee;
	}

	public void setPostFee(Long postFee) {
		this.postFee = postFee;
	}

	public PromotionProfitPostFee getPromotionProfitPostFee() {
		return promotionProfitPostFee;
	}

	public void setPromotionProfitPostFee(PromotionProfitPostFee promotionProfitPostFee) {
		this.promotionProfitPostFee = promotionProfitPostFee;
	}
	
	
}
