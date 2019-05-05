
package com.me.threading.thread;

public class RunnerNonThread{

	public static void main(String[] args){
		for(int i = 1; i <= 3; i++){
			NonThread nonThread = new NonThread("NonThread " + i);
			nonThread.run();
		}
	}

}
