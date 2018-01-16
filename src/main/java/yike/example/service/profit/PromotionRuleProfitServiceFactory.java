package yike.example.service.profit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class PromotionRuleProfitServiceFactory implements  ApplicationContextAware{

	Map<String, IPromotionRuleProfitService> ruleMap = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ruleMap = new HashMap<String, IPromotionRuleProfitService>();
		
		Map<String, IPromotionRuleProfitService> map = applicationContext.getBeansOfType(IPromotionRuleProfitService.class);
		
		Collection<IPromotionRuleProfitService> services = map.values();
		for (IPromotionRuleProfitService otherService : services) {
			ruleMap.put(otherService.promotionRuleType(), otherService);
		}
		
	}
	
	public IPromotionRuleProfitService getProfitService(Byte promotionRuleType, Integer promotionRuleSubType) {
		IPromotionRuleProfitService service = ruleMap.get(promotionRuleType + "_" + promotionRuleSubType);
		if (service != null) {
			return service;
		}
		return ruleMap.get(promotionRuleType + "_");
	}
}
