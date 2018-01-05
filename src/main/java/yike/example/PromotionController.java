package yike.example;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yike.dto.BaseResponseDTO;
import yike.example.service.PromotionInfoService;

@RestController
public class PromotionController {

	@Resource
	private PromotionInfoService promotionInfoService;
	
	@RequestMapping(value="promotion.json", method=RequestMethod.GET)
	public BaseResponseDTO get(Long supplierId, String name) {
		BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
		baseResponseDTO.setStatus(0);
		Map<String, Object> result = new HashMap<>();
		result.put("promotionInfo", promotionInfoService.getBySupplierIdAndName(supplierId, name));
		baseResponseDTO.setResult(result);
		return baseResponseDTO;
	}
}
