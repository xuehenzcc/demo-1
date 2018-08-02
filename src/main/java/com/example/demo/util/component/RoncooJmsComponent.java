/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.util.component;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * @author c0z00k8
 *
 */
@Component
public class RoncooJmsComponent {

	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	@Autowired
	private Queue queue;
	
	public void send(String message){
		this.jmsTemplate.convertAndSend(this.queue,message);
	}
	
	@JmsListener(destination="roncoo.queue")
	public void receiveMessage(String text){
		System.out.println("收到消息：：······"+text);
	}
	
	
}
