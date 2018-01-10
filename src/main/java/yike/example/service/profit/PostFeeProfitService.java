package yike.example.service.profit;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitPostFee;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BasePostFeeRuleService;

/**
 * 包邮优惠
 * @author Administrator
 *
 */
@Service
public class PostFeeProfitService extends BasePostFeeRuleService implements IPromotionRuleProfitService {

	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		
		PromotionRuleProfit promotionRuleProfit = promotionRuleBo.getPromotionRuleProfit();
		JSONObject jsonObject = JSONObject.parseObject(promotionRuleProfit.getValue());
		String promotionDesc = jsonObject.getString("desc");
		PromotionProfitPostFee promotionProfitPostFee = new PromotionProfitPostFee();
		promotionProfitPostFee.setPromotionDesc(promotionDesc);
		promotionProfitPostFee.setPromotionId(promotionRuleBo.getPromotionRule().getId());
		
		promotionProfitBO.setPromotionProfitPostFee(promotionProfitPostFee);
		return promotionProfitBO;
	}

}
