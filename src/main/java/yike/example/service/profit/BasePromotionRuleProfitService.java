package yike.example.service.profit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.constants.PromotionConstants;

@Service
public class BasePromotionRuleProfitService {

	/**
	 * 得到所有优惠收益
	 * <br>
	 * 对于排他性优惠
	 * @param promotionContext
	 * @return
	 */
	public PromotionProfitBO getProfit(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		if (promotionContext.isEmpty()) {
			return null;
		}
		
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		Map<Integer, Collection<PromotionRuleBO>> sortedMap = sortByPriority(promotionContext);
		for (Iterator<Integer> it = sortedMap.keySet().iterator(); it.hasNext();) {
			Integer priority = it.next();
			Collection<PromotionRuleBO> ruleBOs = sortedMap.get(priority);
			
			if (priority == PromotionConstants.PROMOTION_PRIORITY_EXCLUDE) {
				
				for (PromotionRuleBO promotionRuleBO : ruleBOs) {
					
				}
				
			}
			
		}
		
		return promotionProfitBO;
	}
	
	private Map<Integer, Collection<PromotionRuleBO>> sortByPriority(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		Set<PromotionRuleBO> ruleBOs = promotionContext.keySet();
		List<PromotionRuleBO> ruleBOList = new ArrayList<PromotionRuleBO>(ruleBOs);  
		
		//根据groupId分组, 如果groupId为null, 则放到默认为0的group下  
		Function<PromotionRuleBO, Integer> fun = new Function<PromotionRuleBO, Integer>() {
			@Override
			public Integer apply(PromotionRuleBO input) {
				if (input.getPriority() == null) {
					return 0;
				}
				return input.getPriority();
			}
		};
		Multimap<Integer, PromotionRuleBO> index = Multimaps.index(ruleBOList, fun);
		Map<Integer, Collection<PromotionRuleBO>> map = index.asMap();  
		Map<Integer, Collection<PromotionRuleBO>> sortedMap = new TreeMap<Integer, Collection<PromotionRuleBO>>();
		for (Integer priority : map.keySet()) {
			sortedMap.put(priority, map.get(priority));
		}
		
		return sortedMap;
	}
}
