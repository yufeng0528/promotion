package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionLimitStock;
import yike.example.obj.PromotionLimitStockCriteria;

public interface PromotionLimitStockMapper {
    long countByExample(PromotionLimitStockCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionLimitStock record);

    int insertSelective(PromotionLimitStock record);

    List<PromotionLimitStock> selectByExample(PromotionLimitStockCriteria example);

    PromotionLimitStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionLimitStock record);

    int updateByPrimaryKey(PromotionLimitStock record);
}