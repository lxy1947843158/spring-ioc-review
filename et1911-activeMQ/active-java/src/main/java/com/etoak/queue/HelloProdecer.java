package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class HelloProdecer {

	public static void main(String[] args) throws JMSException {
		//1.创建ConnectionFactory(用户名 ,密码,链接地址)
		ConnectionFactory factory =new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		//2.创建Connection
		Connection connection =  factory.createConnection();
		//3创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//4.创建defination
		Queue helloQueue = session.createQueue("hello");
		//5.创建消息生产者
		MessageProducer producer = session.createProducer(helloQueue);
		//6.创建消息
		TextMessage msg = session.createTextMessage("这是第一个hello word消费者");
		//7.
		producer.send(msg);
		producer.close();
		session.close();
		connection.close();
		System.out.println("OK");
	}

}
