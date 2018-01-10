package yike.example.service.profit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionProfitReward;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.constants.PromotionConstants;
import yike.example.obj.PromotionRuleProfit;
import yike.example.service.rule.BaseRewardCouponRuleService;

/**
 * 支持的规则为   <br>
 * 买指定A件商品送X张指定的优惠券 <br>
 * 买指定B件商品送Y张指定的优惠券 <br>
 * 买指定C件商品送Z张指定的优惠券 ....<br>
 * 不支持累加-----
 * @author Administrator
 *
 */
@Service
public class RewardCouponProfitService extends BaseRewardCouponRuleService implements IPromotionRuleProfitService {

	@Resource
	private PromotionRuleProfitService promotionRuleProfitService;
	
	@Override
	public PromotionProfitBO handleProfit(PromotionRuleBO promotionRuleBo, List<CartStockDTO> cartStockDTOs) {
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		
		Long promotionId = promotionRuleBo.getPromotionRule().getPromotionId();
		PromotionRuleProfit profit = promotionRuleProfitService.getByPromotionId(promotionRuleBo.getPromotionRule().getSupplierId(), promotionRuleBo.getPromotionRule().getPromotionId(), promotionRuleBo.getLevel());
		
		List<PromotionProfitReward> rewards = new ArrayList<>();
		JSONObject jsonObject = JSONObject.parseObject(profit.getValue());
		String desc = jsonObject.getString("desc");
		PromotionProfitReward promotionProfitReward = new PromotionProfitReward(promotionId, (int)PromotionConstants.PROMOTION_RULE_SUBTYPE_REWARD_COUPON, desc);
		rewards.add(promotionProfitReward);
		promotionProfitBO.setRewards(rewards);
		
		return promotionProfitBO;
	}

}
