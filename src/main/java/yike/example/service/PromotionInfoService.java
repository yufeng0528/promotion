package yike.example.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import yike.example.dao.PromotionInfoDao;
import yike.example.obj.PromotionInfo;

@Service
public class PromotionInfoService {

	@Resource
	private PromotionInfoDao promotionInfoDao;
	
	public PromotionInfo getBySupplierIdAndName(Long supplierId, String name) {
		return promotionInfoDao.selectBySupplierId(supplierId, name);
	}
}
