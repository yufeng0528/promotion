package yike.example.service;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import yike.example.dao.PromotionInfoDao;
import yike.example.obj.Account;
import yike.example.obj.PromotionInfo;

@Service
public class PromotionInfoService {

	@Resource
	private PromotionInfoDao promotionInfoDao;
	
	public PromotionInfo getBySupplierIdAndName(Long supplierId, String name) {
		return promotionInfoDao.selectBySupplierId(supplierId, name);
	}
	
	@Cacheable(value="pro_info", key="'pro_info' + #promotionInfoId", condition = "#promotionInfoId != null")
	public PromotionInfo getById(Long promotionInfoId) {
		return promotionInfoDao.selectById(promotionInfoId);
	}
	
	
	public void updatePromotionInfo(Account account) {
		return;
	}
}
