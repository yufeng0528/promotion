package yike.example.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


@Component
public class AccountUpdateListener extends BaseListener{

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private final String routingKey = "account.update";
	
	private final String exchange = "account";
	
	private final String queueName = routingKey + QUEUE_NAME;

	public void send(String msg) {
		this.amqpTemplate.convertAndSend(exchange, routingKey, super.addExchangeAndRoutingKey(msg, exchange, routingKey));
	}
	
	public void send(Long id, String name) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("name", name);
		this.amqpTemplate.convertAndSend(exchange, routingKey, super.addExchangeAndRoutingKey(jsonObject, exchange, routingKey));
	}

	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = queueName, durable = "true"), 
			exchange = @Exchange(value = exchange, ignoreDeclarationExceptions = "true"), 
			key = routingKey ))
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
		JSONObject jsonObject = JSONObject.parseObject(text);
		jsonObject.clear();
	}
}
