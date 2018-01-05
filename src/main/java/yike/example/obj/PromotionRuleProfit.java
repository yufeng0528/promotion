package yike.example.obj;

/**
 *   实际优惠json
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionRuleProfit {
    private Long id;

    private Long supplierId;

    private Long promotionId;

    private Long promotionRuleConditionId;

    private String value;

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

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPromotionRuleConditionId() {
        return promotionRuleConditionId;
    }

    public void setPromotionRuleConditionId(Long promotionRuleConditionId) {
        this.promotionRuleConditionId = promotionRuleConditionId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}