
package com.me.threading.thread;

public class RunnerThreadWithPause{

	public static void main(String[] args){
		for(int i = 1; i <= 3; i++){
			MyThreadWithPause myThread = new MyThreadWithPause(0, "Thread " + i);
			myThread.start();
		}
	}

}
