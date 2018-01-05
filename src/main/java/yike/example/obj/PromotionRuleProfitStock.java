package yike.example.obj;

/**
 *   库存限制
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionRuleProfitStock {
    private Long id;

    private Long supplierId;

    private Long promotionId;

    private Long promotionRuleProfitId;

    private Long stockCount;

    /**
     *   库存或者人数
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

    public Long getPromotionRuleProfitId() {
        return promotionRuleProfitId;
    }

    public void setPromotionRuleProfitId(Long promotionRuleProfitId) {
        this.promotionRuleProfitId = promotionRuleProfitId;
    }

    public Long getStockCount() {
        return stockCount;
    }

    public void setStockCount(Long stockCount) {
        this.stockCount = stockCount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}