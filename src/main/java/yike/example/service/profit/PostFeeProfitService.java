package yike.example.service.profit;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionContext;
import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitPostFee;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BasePostFeeRuleService;

/**
 * 包邮优惠
 * 默认是订单优惠
 * @author Administrator
 *
 */
@Service
public class PostFeeProfitService extends BasePostFeeRuleService implements IPromotionRuleProfitService {

	private static Logger logger = LoggerFactory.getLogger(PostFeeProfitService.class);
	
	@Resource
	private ProfitCompareService profitCompareService;
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		logger.info("开始检查优惠冲突 this:" + promotionRuleBo.getPromotionRule().getId());
		PromotionRuleProfit promotionRuleProfit = promotionRuleBo.getPromotionRuleProfit();
		JSONObject jsonObject = JSONObject.parseObject(promotionRuleProfit.getValue());
		String promotionDesc = jsonObject.getString("desc");
		
		Long postFee = PromotionContext.getCartDTO().getPostFee();

		if (!profitCompareService.checkOrderPromotion(cartStockDTOs, postFee)) {
			return null;
		}
		
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		
		PromotionProfitPostFee promotionProfitPostFee = new PromotionProfitPostFee();
		promotionProfitPostFee.setPromotionDesc(promotionDesc);
		promotionProfitPostFee.setPromotionId(promotionRuleBo.getPromotionRule().getId());
		promotionProfitPostFee.setTotalProfitPrice(postFee);
		PromotionContext.getCartDTO().setPromotionProfitPostFee(promotionProfitPostFee);
		
		//TODO 如何设置包邮优惠
		
		return promotionProfitBO;
	}

}
