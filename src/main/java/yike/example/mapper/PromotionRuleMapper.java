package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionRule;
import yike.example.obj.PromotionRuleCriteria;

public interface PromotionRuleMapper {
    long countByExample(PromotionRuleCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionRule record);

    int insertSelective(PromotionRule record);

    List<PromotionRule> selectByExample(PromotionRuleCriteria example);

    PromotionRule selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionRule record);

    int updateByPrimaryKey(PromotionRule record);
}