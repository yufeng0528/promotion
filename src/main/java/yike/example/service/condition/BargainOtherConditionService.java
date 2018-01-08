package yike.example.service.condition;

import java.util.List;

import org.springframework.stereotype.Service;

import yike.bo.PromotionRuleBO;
import yike.dto.CartCustomerDTO;
import yike.dto.CartStockDTO;
import yike.example.service.rule.BaseBargainRuleService;

/**
 * 特价
 * @author Administrator
 *
 */
@Service
public class BargainOtherConditionService extends BaseBargainRuleService implements IPromotionRuleOtherService {

	@Override
	public Boolean filterByOtherRule(PromotionRuleBO promotionRule, CartCustomerDTO cartCustomerContext, List<CartStockDTO> promotionContext) {
		// 校验库存
		// 校验个人购买数
		// ....
		if (cartCustomerContext.getCustomerId() == 1L) {
			return true;
		}
		return false;
	}

	@Override
	public Long lockStock(PromotionRuleBO promotionRule, CartCustomerDTO cartCustomerContext, List<CartStockDTO> promotionContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean useStock(Long orderId, Long promotionStockId) {
		// TODO Auto-generated method stub
		return null;
	}

}
