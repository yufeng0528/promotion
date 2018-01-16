package yike.example.service.profit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import yike.bo.PromotionContext;
import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitReward;
import yike.bo.PromotionProfitStockItemDeduct;
import yike.dto.CartStockDTO;

@Service
public class ProfitCompareService {
	
	private static Logger logger = LoggerFactory.getLogger(ProfitCompareService.class);

	//当时组合优惠时
	public boolean checkGroupPromotion(CartStockDTO cartStockDTO, Long totalProfitValue) {
		PromotionProfitBO groupPromotion = cartStockDTO.getGroupPromotion();
		if (groupPromotion == null) {
			return true;
		}
		
		//TODO 实现compare接口
		//如果是奖品优惠
		PromotionProfitReward reward = groupPromotion.getReward();
		if (reward != null) {
			if (reward.getTotalProfitPrice() < totalProfitValue) {
				return true;
			}
			logger.info("已有更佳的优惠 " + reward.getPromotionId());
			return false;
		}
		
		//如果是现金优惠
		PromotionProfitStockItemDeduct stockItemDeductNow = groupPromotion.getPromotionProfitStockItemDeduct();
		Long totalProfitPrice = 0L;
		List<CartStockDTO> cartStockDTOs = PromotionContext.getCartDTO().getCartStocks();
		for (CartStockDTO cartStockDTO0 : cartStockDTOs) {
			if (stockItemDeductNow.getPromotionId().equals(cartStockDTO0.getGroupPromotion().getPromotionProfitStockItemDeduct().getPromotionId())) {
				totalProfitPrice += cartStockDTO0.getGroupPromotion().getPromotionProfitStockItemDeduct().getTotalProfitPrice();
			}
		}
		if (totalProfitPrice < totalProfitValue) {
			return true;
		}
		
		logger.info("已有更佳的优惠 " + stockItemDeductNow.getPromotionId());
		return false;
	}
	
	//TODO 订单优惠时
	public boolean checkOrderPromotion(List<CartStockDTO> cartStockDTOs, Long totalProfitValue) {
		
		return false;
	}
}
