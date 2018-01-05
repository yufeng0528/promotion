package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionLimit;
import yike.example.obj.PromotionLimitCriteria;

public interface PromotionLimitMapper {
    long countByExample(PromotionLimitCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionLimit record);

    int insertSelective(PromotionLimit record);

    List<PromotionLimit> selectByExample(PromotionLimitCriteria example);

    PromotionLimit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionLimit record);

    int updateByPrimaryKey(PromotionLimit record);
}