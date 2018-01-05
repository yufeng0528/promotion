package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionRuleProfitStockStat;
import yike.example.obj.PromotionRuleProfitStockStatCriteria;

public interface PromotionRuleProfitStockStatMapper {
    long countByExample(PromotionRuleProfitStockStatCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionRuleProfitStockStat record);

    int insertSelective(PromotionRuleProfitStockStat record);

    List<PromotionRuleProfitStockStat> selectByExample(PromotionRuleProfitStockStatCriteria example);

    PromotionRuleProfitStockStat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionRuleProfitStockStat record);

    int updateByPrimaryKey(PromotionRuleProfitStockStat record);
}