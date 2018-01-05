package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionRuleCondition;
import yike.example.obj.PromotionRuleConditionCriteria;

public interface PromotionRuleConditionMapper {
    long countByExample(PromotionRuleConditionCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionRuleCondition record);

    int insertSelective(PromotionRuleCondition record);

    List<PromotionRuleCondition> selectByExample(PromotionRuleConditionCriteria example);

    PromotionRuleCondition selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionRuleCondition record);

    int updateByPrimaryKey(PromotionRuleCondition record);
}