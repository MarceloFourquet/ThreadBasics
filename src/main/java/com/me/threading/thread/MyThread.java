
package com.me.threading.thread;

class MyThread extends Thread{

	private String name;

	public MyThread(String name){
		this.name = name;
	}

	@Override
	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", name, i);
		}
	}

}
