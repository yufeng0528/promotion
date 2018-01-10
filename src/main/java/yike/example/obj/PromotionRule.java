package yike.example.obj;

/**
 *   优惠规则
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionRule {
    private Long id;

    private Long supplierId;

    private Long promotionId;

    /**
     *   优惠类型,打折,立减，特价
     *
     */
    private Byte type;

    private Integer subType;
    
    public PromotionRule() {
    	
    }
    
    public PromotionRule(Long promotionId) {
    	this.promotionId = promotionId;
    }

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

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }
}