package yike.example.obj;

import java.util.Date;

/**
 *   用户得到优惠记录
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionCustomerRecord {
    private Long id;

    private Long supplierId;

    private Long customerId;

    private Long promotionId;

    private Long promotionRuleProfit;

    private String desc;

    private Long referId;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPromotionRuleProfit() {
        return promotionRuleProfit;
    }

    public void setPromotionRuleProfit(Long promotionRuleProfit) {
        this.promotionRuleProfit = promotionRuleProfit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getReferId() {
        return referId;
    }

    public void setReferId(Long referId) {
        this.referId = referId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}