
package com.me.threading.intermediate;

public class RunnerThreadNonJoin{

	public static void main(String[] args){
		Thread thread1 = new Thread(new JoinThread(4000, "Thread 1"));
		Thread thread2 = new Thread(new JoinThread(4000, "Thread 2"));
		Thread thread3 = new Thread(new JoinThread(4000, "Thread 3"));
		thread1.start();
		thread2.start();
		thread3.start();
		System.out.println("All three threads have finished execution");
	}

}

class JoinThread implements Runnable{
	
	private int time;
	private String name;
		
	public JoinThread(int time, String name){
		this.time = time;
		this.name = name;
	}

	@Override
	public void run(){
		System.out.printf("Thread started -> %s%n", name);
		try{
			Thread.sleep(time);
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		System.out.printf("Thread ended -> %s%n", name);
	}
	
}
