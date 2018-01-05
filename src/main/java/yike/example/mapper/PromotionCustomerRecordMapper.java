package yike.example.mapper;

import java.util.List;
import yike.example.obj.PromotionCustomerRecord;
import yike.example.obj.PromotionCustomerRecordCriteria;

public interface PromotionCustomerRecordMapper {
    long countByExample(PromotionCustomerRecordCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PromotionCustomerRecord record);

    int insertSelective(PromotionCustomerRecord record);

    List<PromotionCustomerRecord> selectByExample(PromotionCustomerRecordCriteria example);

    PromotionCustomerRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PromotionCustomerRecord record);

    int updateByPrimaryKey(PromotionCustomerRecord record);
}