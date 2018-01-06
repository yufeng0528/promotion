package yike.example.service;

import java.util.List;

import yike.bo.PromotionRuleBO;
import yike.dto.CartCustomerDTO;
import yike.dto.CartStockDTO;

public interface IPromotionRuleOtherService {

	/**
	 * 预成单
	 * @return
	 */
	Boolean filterByOtherRule(PromotionRuleBO promotionRule, CartCustomerDTO cartCustomerContext, List<CartStockDTO> promotionContext);
	
	/**
	 * 下单--锁定促销优惠库存
	 * @return 促销优惠库存ID
	 */
	Long lockStock(PromotionRuleBO promotionRule, CartCustomerDTO cartCustomerContext, List<CartStockDTO> promotionContext);
	
	/**
	 * 支付完成--使用促销优惠库存
	 * @return
	 */
	Boolean useStock(Long orderId, Long promotionStockId);
	
	/**
	 * 具体规则promotion_rule的type
	 * @return
	 */
	Byte promotionRuleType();
}
