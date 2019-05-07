
package com.me.threading.thread;

class MyThread extends Thread{

	public MyThread(String name){
		super(name);
	}

	@Override
	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", getName(), i);
		}
	}

}
