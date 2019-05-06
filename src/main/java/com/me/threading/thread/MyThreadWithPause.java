
package com.me.threading.thread;

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
			try{
				System.out.printf("%s paused %d miliseconds%n", name, time);
				Thread.sleep(time);
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

}
