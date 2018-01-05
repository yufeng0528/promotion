package yike.example.obj;

/**
 *   促销条件
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionRuleCondition {
    private Long id;

    private Long supplierId;

    private Long promotionId;

    /**
     *   数量
     *
     */
    private Integer count;

    /**
     *   金额
     *
     */
    private Long amount;

    /**
     *   阶梯
     *
     */
    private Byte level;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }
}