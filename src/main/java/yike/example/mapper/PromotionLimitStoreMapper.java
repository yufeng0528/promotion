package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionLimitStore;
import yike.example.obj.PromotionLimitStoreCriteria;

public interface PromotionLimitStoreMapper {
    long countByExample(PromotionLimitStoreCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionLimitStore record);

    int insertSelective(PromotionLimitStore record);

    List<PromotionLimitStore> selectByExample(PromotionLimitStoreCriteria example);

    PromotionLimitStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionLimitStore record);

    int updateByPrimaryKey(PromotionLimitStore record);
}