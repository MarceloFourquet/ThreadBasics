
package com.me.threading.intermediate;

import java.util.ArrayList;

public class RunnerYield1{

	public static void main(String[] args){
		
		ArrayList<ThreadYield1> list = new ArrayList<>();
		for(int i = 1; i <= 3; i++){
			ThreadYield1 ty = new ThreadYield1("Thread " + i, i + 5);
			list.add(ty);
			ty.start();
		}
		
		list.forEach((ty) -> {
			try{
				ty.join();
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		});
	}
	
}

class ThreadYield1 extends Thread{
	
	private String name;
	private int stopCount;
	
	public ThreadYield1 (String name, int stopCount){
		this.name = name;
		this.stopCount = stopCount;
	}
	
	@Override
	@SuppressWarnings("CallToThreadYield")
	public void run(){
		for(int i = 1; i <= 50; i++){
			System.out.printf("Running %s - Step: %d%n", name, i);
			if(i % stopCount == 0){
				System.out.printf("Stopping thread: %s%n", name);
				yield();
			}
		}
	}
}
