
package com.me.threading.intermediate;

public class RunnerThreadJoin1{

	public static void main(String[] args){
		
		Thread thread1 = new Thread(new Join1Thread(2000, "Thread 1"));
		Thread thread2 = new Thread(new Join1Thread(4000, "Thread 2"));
		
		System.out.println("Starting Thread 1...");
		thread1.start();
		
		System.out.println("Waiting for Thread 1 to complete...");
		try{
			thread1.join(1000);
		}catch(InterruptedException ex){
			ex.getMessage();
		}
		
		System.out.println("Waiting enough! Starting Thread 2 now.");
		thread2.start();
	}
	
}

class Join1Thread implements Runnable{

	private int time;
	private String name;
	
	public Join1Thread(int time, String name){
		this.time = time;
		this.name = name;
	}
	
	@Override
	public void run(){
		System.out.printf("Entering Thread -> %s%n", name);
		try{
			Thread.sleep(time);
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		System.out.printf("Exiting Thread -> %s%n", name);
	}

}
