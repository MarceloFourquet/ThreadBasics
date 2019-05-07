
package com.me.threading.runnable;

public class RunnerLambda{

	public static void main(String[] args){
		// Opción 1 - No genera una clase extra
		Runnable runnable = () -> {
			for(int i = 1; i <= 20; i++){
				System.out.printf("Running %s - Step: %d%n", Thread.currentThread().getName(), i);
			}
		};
		for(int i = 1; i <= 3; i++){
			Thread thread = new Thread(runnable, "Thread " + i);
			thread.start();
		}
		
		// Opción 2 - No genera una clase extra
		for(int i = 1; i <= 3; i++){
			Thread thread = new Thread(() -> {
				for(int j = 1; j <= 20; j++){
					System.out.printf("Running %s - Step: %d%n", Thread.currentThread().getName(), j);
				}
			}, "Thread " + i);
			thread.start();
		}
	}

}
