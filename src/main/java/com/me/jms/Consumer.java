
package com.me.jms;

import javax.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer{
	
	private Connection connection;
	private	Session session;
	private MessageConsumer messageConsumer;

	public void create(String destinationName) throws JMSException{
		
		ConnectionFactory connectionFactory;
		Destination destination;
		
		final String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
		final int autoAcknowledge = Session.AUTO_ACKNOWLEDGE;
		
		connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		connection = connectionFactory.createConnection();		
		session = connection.createSession(false, autoAcknowledge);
		destination = session.createQueue(destinationName);
		messageConsumer = session.createConsumer(destination);

		connection.start();
		
	}
	
	public void close() throws JMSException{
		
		connection.close();
		
	}
	
	public String get() throws JMSException{
		
		Message message = messageConsumer.receive();
		
		if(message != null){
			TextMessage textMessage = (TextMessage) message;
			return textMessage.getText();
		}
		return "";
		
	}
}
