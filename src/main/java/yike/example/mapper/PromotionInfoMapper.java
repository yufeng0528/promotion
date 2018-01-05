package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionInfo;
import yike.example.obj.PromotionInfoCriteria;

public interface PromotionInfoMapper {
    long countByExample(PromotionInfoCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionInfo record);

    int insertSelective(PromotionInfo record);

    List<PromotionInfo> selectByExample(PromotionInfoCriteria example);

    PromotionInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionInfo record);

    int updateByPrimaryKey(PromotionInfo record);
}