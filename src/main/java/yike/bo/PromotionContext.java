package yike.bo;

import yike.dto.CartCustomerDTO;

public class PromotionContext {
	private static ThreadLocal<CartCustomerDTO> sessionKeyHolder = new ThreadLocal<>();

	public static void putCartCustomer(CartCustomerDTO cartCustomerDTO) {
		sessionKeyHolder.set(cartCustomerDTO);
	}
	
	public static CartCustomerDTO getCartCustomer() {
		return sessionKeyHolder.get();
	}
	
}
