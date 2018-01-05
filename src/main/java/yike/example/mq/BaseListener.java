package yike.example.mq;

import com.alibaba.fastjson.JSONObject;

public class BaseListener {
	
	protected final String QUEUE_NAME = ".QUEUE";

	protected String addExchangeAndRoutingKey(Object content, String exchange, String routingKey) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("routingKey", routingKey);
		jsonObject.put("content", content);
		jsonObject.put("exchange", exchange);
		return jsonObject.toJSONString();
	}
	
}
