
package com.me.threading.thread;

import static org.apache.commons.lang3.RandomUtils.nextInt;

class MyThreadWithPause extends Thread{

	private int time;
	private String name;

	public MyThreadWithPause(int time, String name){
		this.time = time;
		this.name = name;
	}

	@Override
	@SuppressWarnings("SleepWhileInLoop")
	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", name, i);
			time = nextInt(1000, 2000);
			System.out.printf("%s paused %d miliseconds%n", name, time);
			try{
				Thread.sleep(time);
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

}
