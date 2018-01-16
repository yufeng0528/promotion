package yike.dto;

import java.util.List;

import yike.bo.PromotionProfitBO;

/**
 * 购物车商品上下文
 * 
 * @author Administrator
 *
 */
public class CartStockDTO {

	/**
	 * 购物车商品id
	 */
	private Long id;

	/**
	 * 商品id
	 */
	private Long stockId;

	/**
	 * sku id
	 */
	private Long skuId;

	/**
	 * 购买数量
	 */
	private Long shoppingCount;
	
	/**
	 * 单价
	 */
	private Long price;
	
	/**
	 * 特价优惠
	 */
	private PromotionProfitBO specialPromotion;
	
	/**
	 * 组合优惠
	 */
	private PromotionProfitBO groupPromotion;
	
	/**
	 * 其他可选优惠
	 */
	private List<PromotionProfitBO> alternativeGroupPromotion;
	
	/**
	 * 为满足的优惠
	 */
	private List<PromotionProfitBO> unsatfiyGroupPromotion;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getShoppingCount() {
		return shoppingCount;
	}

	public void setShoppingCount(Long shoppingCount) {
		this.shoppingCount = shoppingCount;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public PromotionProfitBO getSpecialPromotion() {
		return specialPromotion;
	}

	public void setSpecialPromotion(PromotionProfitBO specialPromotion) {
		this.specialPromotion = specialPromotion;
	}

	public List<PromotionProfitBO> getAlternativeGroupPromotion() {
		return alternativeGroupPromotion;
	}

	public void setAlternativeGroupPromotion(List<PromotionProfitBO> alternativeGroupPromotion) {
		this.alternativeGroupPromotion = alternativeGroupPromotion;
	}

	public List<PromotionProfitBO> getUnsatfiyGroupPromotion() {
		return unsatfiyGroupPromotion;
	}

	public void setUnsatfiyGroupPromotion(List<PromotionProfitBO> unsatfiyGroupPromotion) {
		this.unsatfiyGroupPromotion = unsatfiyGroupPromotion;
	}

	public PromotionProfitBO getGroupPromotion() {
		return groupPromotion;
	}

	public void setGroupPromotion(PromotionProfitBO groupPromotion) {
		this.groupPromotion = groupPromotion;
	}

}
