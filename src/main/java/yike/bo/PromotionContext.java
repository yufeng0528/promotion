package yike.bo;

import yike.dto.CartCustomerDTO;
import yike.dto.CartDTO;

public class PromotionContext {
	private static ThreadLocal<CartCustomerDTO> sessionCustomerKeyHolder = new ThreadLocal<>();
	
	private static ThreadLocal<CartDTO> sessionCartKeyHolder = new ThreadLocal<>();

	public static void putCartCustomer(CartCustomerDTO cartCustomerDTO) {
		sessionCustomerKeyHolder.set(cartCustomerDTO);
	}
	
	public static CartCustomerDTO getCartCustomer() {
		return sessionCustomerKeyHolder.get();
	}
	
	public static void putCartDTO(CartDTO cartDTO) {
		sessionCartKeyHolder.set(cartDTO);
	}
	
	public static CartDTO getCartDTO() {
		return sessionCartKeyHolder.get();
	}
	
}
