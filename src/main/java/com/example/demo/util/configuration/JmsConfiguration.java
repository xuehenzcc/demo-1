/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月18日
 */
package com.example.demo.util.configuration;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author c0z00k8
 *
 */
@Configuration
public class JmsConfiguration {

	@Bean
	public Queue queue(){
		return new ActiveMQQueue("roncoo.queue");
	}
}
