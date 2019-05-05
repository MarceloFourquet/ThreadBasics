
package com.me.threading.runnable;

public class RunnerRunnable{

	public static void main(String[] args){
		for(int i = 1; i <= 3; i++){
			Thread thread = new Thread(new MyRunnable("Thread " + i));
			thread.start();
		}
	}

}
