package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionRuleProfitStock;
import yike.example.obj.PromotionRuleProfitStockCriteria;

public interface PromotionRuleProfitStockMapper {
    long countByExample(PromotionRuleProfitStockCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionRuleProfitStock record);

    int insertSelective(PromotionRuleProfitStock record);

    List<PromotionRuleProfitStock> selectByExample(PromotionRuleProfitStockCriteria example);

    PromotionRuleProfitStock selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionRuleProfitStock record);

    int updateByPrimaryKey(PromotionRuleProfitStock record);
}