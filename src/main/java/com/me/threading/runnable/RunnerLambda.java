
package com.me.threading.runnable;

public class RunnerLambda{

	public static void main(String[] args){
		Runnable runnable = () -> {
			for(int i = 1; i <= 20; i++){
				System.out.printf("Running %s - Step: %d%n", Thread.currentThread().getName(), i);
			}
		};
		for(int i = 1; i <= 3; i++){
			Thread thread = new Thread(runnable, "Thread " + i);
			thread.start();
		}
	}

}
