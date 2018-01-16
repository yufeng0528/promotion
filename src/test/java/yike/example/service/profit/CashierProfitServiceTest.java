package yike.example.service.profit;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

import yike.DemoApplication;
import yike.bo.PromotionProfitBO;
import yike.bo.PromotionRuleBO;
import yike.dto.CartStockDTO;
import yike.example.obj.PromotionRule;
import yike.example.obj.PromotionRuleProfit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class CashierProfitServiceTest {
	
	@Resource
	private CashierProfitService cashierProfitService;

	@Test
	public void contextLoads() {
		int x = 0;
		x = 1/1;
		Assert.assertTrue("错误，正确的返回值为200", x == 1);
	}
	
	/**
	 * 减5分--商品10分*2 1分*3
	 */
	@Test
	public void handleProfit1() {
		PromotionRuleBO promotionRuleBo = new PromotionRuleBO();
		
		PromotionRuleProfit promotionRuleProfit = new PromotionRuleProfit();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("promotionValue", 5);
		promotionRuleProfit.setValue(jsonObject.toJSONString());
		promotionRuleBo.setPromotionRuleProfit(promotionRuleProfit);
		promotionRuleBo.setPromotionRule(new PromotionRule(1L));
		
		List<CartStockDTO> cartStockDTOs = new ArrayList<>();
		CartStockDTO cartStockDTO = new CartStockDTO();
		cartStockDTO.setPrice(10L);
		cartStockDTO.setShoppingCount(2L);
		cartStockDTOs.add(cartStockDTO);
		cartStockDTO = new CartStockDTO();
		cartStockDTO.setPrice(1L);
		cartStockDTO.setShoppingCount(3L);
		cartStockDTOs.add(cartStockDTO);
		
		cashierProfitService.handleProfit(promotionRuleBo, cartStockDTOs);
		
		PromotionProfitBO promotionProfitBO = cartStockDTOs.get(0).getGroupPromotion();
		Assert.assertNotNull(promotionProfitBO);
		Assert.assertEquals(promotionProfitBO.getPromotionProfitStockItemDeduct().getTotalProfitPrice().intValue(), 4);
	}
	
	/**
	 * 减24分--商品10分*2 1分*3
	 */
	@Test
	public void handleProfit2() {
		PromotionRuleBO promotionRuleBo = new PromotionRuleBO();
		
		PromotionRuleProfit promotionRuleProfit = new PromotionRuleProfit();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("promotionValue", 24);
		promotionRuleProfit.setValue(jsonObject.toJSONString());
		promotionRuleBo.setPromotionRuleProfit(promotionRuleProfit);
		promotionRuleBo.setPromotionRule(new PromotionRule(1L));
		
		List<CartStockDTO> cartStockDTOs = new ArrayList<>();
		CartStockDTO cartStockDTO = new CartStockDTO();
		cartStockDTO.setPrice(10L);
		cartStockDTO.setShoppingCount(2L);
		cartStockDTOs.add(cartStockDTO);
		cartStockDTO = new CartStockDTO();
		cartStockDTO.setPrice(1L);
		cartStockDTO.setShoppingCount(3L);
		cartStockDTOs.add(cartStockDTO);
		
		cashierProfitService.handleProfit(promotionRuleBo, cartStockDTOs);
		
		PromotionProfitBO promotionProfitBO = cartStockDTOs.get(0).getGroupPromotion();
		Assert.assertNotNull(promotionProfitBO);
		Assert.assertEquals(promotionProfitBO.getPromotionProfitStockItemDeduct().getTotalProfitPrice().intValue(), 20);
	}
}
