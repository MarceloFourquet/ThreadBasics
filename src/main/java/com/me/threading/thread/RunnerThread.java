
package com.me.threading.thread;

public class RunnerThread{

	public static void main(String[] args){
		for(int i = 1; i <= 3; i++){
			MyThread myThread = new MyThread("Thread " + i);
			myThread.start();
		}
	}

}
