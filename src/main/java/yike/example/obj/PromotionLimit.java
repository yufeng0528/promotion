package yike.example.obj;

/**
 *   限制条件
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionLimit {
    private Long id;

    private Long supplierId;

    private Long promotionId;

    /**
     *   限制条件类型
     *
     */
    private Byte type;

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

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}