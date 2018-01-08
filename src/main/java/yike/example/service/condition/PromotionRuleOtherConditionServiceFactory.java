package yike.example.service.condition;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class PromotionRuleOtherConditionServiceFactory implements  ApplicationContextAware{

	Map<Byte, IPromotionRuleOtherService> ruleOtherServiceMap = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ruleOtherServiceMap = new HashMap<Byte, IPromotionRuleOtherService>();
		
		Map<String, IPromotionRuleOtherService> map = applicationContext.getBeansOfType(IPromotionRuleOtherService.class);
		
		Collection<IPromotionRuleOtherService> services = map.values();
		for (IPromotionRuleOtherService otherService : services) {
			ruleOtherServiceMap.put(otherService.promotionRuleType(), otherService);
		}
		
	}
	
	public IPromotionRuleOtherService getRuleOtherService(Byte promotionRuleType) {
		return ruleOtherServiceMap.get(promotionRuleType);
	}
}
