package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionPriority;
import yike.example.obj.PromotionPriorityCriteria;

public interface PromotionPriorityMapper {
    long countByExample(PromotionPriorityCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionPriority record);

    int insertSelective(PromotionPriority record);

    List<PromotionPriority> selectByExample(PromotionPriorityCriteria example);

    PromotionPriority selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionPriority record);

    int updateByPrimaryKey(PromotionPriority record);
}