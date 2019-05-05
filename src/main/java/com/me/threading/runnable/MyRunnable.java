
package com.me.threading.runnable;

public class MyRunnable implements Runnable{

	private String name;

	public MyRunnable(String name){
		this.name = name;
	}

	@Override
	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", name, i);
		}
	}

}
