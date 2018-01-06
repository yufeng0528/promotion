package yike.dto;

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

}
