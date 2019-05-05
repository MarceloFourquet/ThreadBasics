
package com.me.jms;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer{
	
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	
	public void create (String destinationName) throws JMSException{
		
		ConnectionFactory connectionFactory;
		Destination destination;
		
		final String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
		final int autoAcknowledge = Session.AUTO_ACKNOWLEDGE;
		
		connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, autoAcknowledge);
		destination = session.createQueue(destinationName);
		messageProducer = session.createProducer(destination);
		
	}
	
	public void close() throws JMSException{
		
		connection.close();
		
	}
	
	public void send (String customer) throws JMSException{
		
		TextMessage textMessage = session.createTextMessage(customer);
		messageProducer.send(textMessage);
		
	}
}
