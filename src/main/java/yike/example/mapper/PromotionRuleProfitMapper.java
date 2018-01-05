package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionRuleProfit;
import yike.example.obj.PromotionRuleProfitCriteria;

public interface PromotionRuleProfitMapper {
    long countByExample(PromotionRuleProfitCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionRuleProfit record);

    int insertSelective(PromotionRuleProfit record);

    List<PromotionRuleProfit> selectByExample(PromotionRuleProfitCriteria example);

    PromotionRuleProfit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionRuleProfit record);

    int updateByPrimaryKey(PromotionRuleProfit record);
}