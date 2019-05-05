
package com.me.threading.thread;

class NonThread{

	private String name;

	public NonThread(String name){
		this.name = name;
	}

	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", name, i);
		}
	}

}
