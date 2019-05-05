
package com.me.jms;

import javax.jms.JMSException;

public class RunnerJMSProducer{

	public static void main(String[] args) throws JMSException{
		
		Producer producer = new Producer();
		producer.create("Ejemplo JMS");
		
		for(int i = 1; i <= 5; i++){
			producer.send("Mensaje " + i);
		}
	
		producer.close();
	}
	
}
