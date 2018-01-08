package yike.example.service.profit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yike.example.dao.PromotionRuleProfitDao;
import yike.example.obj.PromotionRuleProfit;

@Service
public class PromotionRuleProfitService {

	@Resource
	private PromotionRuleProfitDao promotionRuleProfitDao;
	
	public List<PromotionRuleProfit> getByPromotionId(Long supplierId, Long promotionId) {
		return promotionRuleProfitDao.selectList(supplierId, promotionId, null);
	}
	
	public PromotionRuleProfit getByPromotionId(Long supplierId, Long promotionId, Integer level) {
		List<PromotionRuleProfit> list = promotionRuleProfitDao.selectList(supplierId, promotionId, null);
		if (list != null && list.size() >= level) {
			return list.get(level);
		}
		return null;
	}
}
