package yike.bo;

import java.util.ArrayList;
import java.util.List;

public class PromotionProfitStockItem {

	private List<PromotionProfitStockItemDeduct> list = new ArrayList<>();
	
	/**
	 * 总优惠
	 */
	private Long totalDeduct;
	
	public List<PromotionProfitStockItemDeduct> getList() {
		return list;
	}

	public void setList(List<PromotionProfitStockItemDeduct> list) {
		this.list = list;
	}

	public Long getTotalDeduct() {
		return totalDeduct;
	}

	public void setTotalDeduct(Long totalDeduct) {
		this.totalDeduct = totalDeduct;
	}
}
