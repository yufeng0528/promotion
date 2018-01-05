package yike.example.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import yike.example.mapper.PromotionInfoMapper;
import yike.example.obj.PromotionInfo;
import yike.example.obj.PromotionInfoCriteria;

@Service
public class PromotionInfoDao {

	@Resource
	private PromotionInfoMapper promotionInfoMapper;
	
	public PromotionInfo selectById(Long id) {
		return promotionInfoMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 
	 * @param supplierId
	 * @param name	假设唯一 这里只是做演示
	 * @return
	 */
	public PromotionInfo selectBySupplierId(Long supplierId, String name) {
		PromotionInfoCriteria promotionInfoCriteria = new PromotionInfoCriteria();
		promotionInfoCriteria.createCriteria().andSupplierIdEqualTo(supplierId)
		.andNameEqualTo(name);
		promotionInfoCriteria.setLimit(1);
		promotionInfoCriteria.setOffset(0);
		List<PromotionInfo> promotionInfos = promotionInfoMapper.selectByExample(promotionInfoCriteria);
		if (CollectionUtils.isNotEmpty(promotionInfos)) {
			return promotionInfos.get(0);
		}
		return null;
	}
}
