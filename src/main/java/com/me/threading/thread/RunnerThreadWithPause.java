
package com.me.threading.thread;

import java.util.Random;

public class RunnerThreadWithPause{

	public static void main(String[] args){
		Random rnd = new Random();
		int time;
		for(int i = 1; i <= 3; i++){
			time = rnd.nextInt(1000) + 1000;
			MyThreadWithPause myThread = new MyThreadWithPause(time, "Thread " + i);
			myThread.start();
		}
	}

}
