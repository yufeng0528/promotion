package yike.example.obj;

/**
 *   优先级
 *
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class PromotionPriority {
    private Long id;

    /**
     *   优惠类型
     *
     */
    private Byte promotionType;

    /**
     *   优先级
     *
     */
    private Integer priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Byte promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}