
package com.me.threading.intermediate;

public class RunnerYield2{

	@SuppressWarnings("CallToThreadYield")
	public static void main(String[] args){
		ThreadYield2 myThread = new ThreadYield2("myThread");
		myThread.start();
		for(int i = 0; i < 5; i++){
			Thread.yield();
			System.out.printf("%s in control%n", Thread.currentThread().getName());
		}
	}
	
}

class ThreadYield2 extends Thread{
	
	private String name;
	
	public ThreadYield2 (String name){
		this.name = name;
	}
	
	@Override
	public void run(){
		for(int i = 1; i <= 5; i++){
			System.out.printf("%s in control - Step: %d%n", name, i);
		}
	}
}