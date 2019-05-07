
package com.me.threading.intermediate;

public class RunnerThreadJoin1{

	public static void main(String[] args){
		Thread thread1 = new Thread(new ThreadJoin1(4000, "Thread 1"));
		Thread thread2 = new Thread(new ThreadJoin1(4000, "Thread 2"));
		Thread thread3 = new Thread(new ThreadJoin1(4000, "Thread 3"));
		thread1.start();
		thread2.start();
		thread3.start();
		try{
			thread1.join();
			thread2.join();
			thread3.join();
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		System.out.println("The program is finished");
	}

}

class ThreadJoin1 implements Runnable{
	
	private int time;
	private String name;
	
	public ThreadJoin1(int time, String name){
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
