package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionLimitCustomer;
import yike.example.obj.PromotionLimitCustomerCriteria;

public interface PromotionLimitCustomerMapper {
    long countByExample(PromotionLimitCustomerCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionLimitCustomer record);

    int insertSelective(PromotionLimitCustomer record);

    List<PromotionLimitCustomer> selectByExample(PromotionLimitCustomerCriteria example);

    PromotionLimitCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionLimitCustomer record);

    int updateByPrimaryKey(PromotionLimitCustomer record);
}