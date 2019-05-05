
package com.me.jms;

import javax.jms.JMSException;

public class RunnerJMSConsumer{

	public static void main(String[] args) throws JMSException{
		
		Consumer consumer = new Consumer();
		consumer.create("Ejemplo JMS");
		
		String msg;
		while(!(msg = consumer.get()).equals("")){
			System.out.printf("Message received %s%n", msg);
		}
		
		consumer.close();
	}

}
