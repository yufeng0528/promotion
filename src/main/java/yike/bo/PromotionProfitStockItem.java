package yike.bo;

import java.util.ArrayList;
import java.util.List;

public class PromotionProfitStockItem {

	private List<PromotionProfitStockItemDeduct> list = new ArrayList<>();
	
	public List<PromotionProfitStockItemDeduct> getList() {
		return list;
	}

	public void setList(List<PromotionProfitStockItemDeduct> list) {
		this.list = list;
	}
}
