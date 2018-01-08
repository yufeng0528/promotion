package yike.example.service.profit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

import yike.bo.PromotionProfitBO;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;

@Service
public class BasePromotionRuleProfitService {

	public PromotionProfitBO getProfit(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		if (promotionContext.isEmpty()) {
			return null;
		}
		PromotionProfitBO promotionProfitBO = new PromotionProfitBO();
		return promotionProfitBO;
	}
	
	private List<List<Object>> sortByPriority(Map<PromotionRuleBO, List<CartStockDTO>> promotionContext) {
		Set<PromotionRuleBO> ruleBOs = promotionContext.keySet();
		List<PromotionRuleBO> ruleBOList = new ArrayList<PromotionRuleBO>(ruleBOs);  
		Collections.sort(ruleBOList, new Comparator<PromotionRuleBO>() {

			@Override
			public int compare(PromotionRuleBO o1, PromotionRuleBO o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}
		});
		
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
		for (Map.Entry<Integer, Collection<PromotionRuleBO>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " <---> " + entry.getValue());
		}
		
		return null;
	}
}
