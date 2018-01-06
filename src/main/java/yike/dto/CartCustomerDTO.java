package yike.dto;

import java.util.List;

/**
 * 购物车-用户上下文
 * 变化不是非常频繁的参数
 * @author Administrator
 *
 */
public class CartCustomerDTO {

	/**
	 * 用户id
	 */
	private Long customerId;
	
	/**
	 * 所在区域
	 */
	private Long districtId;
	
	/**
	 * 所属门店 
	 */
	private Long storeId;
	
	/**
	 * 渠道
	 */
	private String source;
	
	/**
	 * 标签
	 */
	private List<String> tags;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	/**
	 * 等级
	 */
	private Integer level;
	
	/**
	 * 是否新用户
	 */
	private Boolean isNew;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}
	
	
}
