
package com.me.threading.thread;

class MyThreadWithPause extends Thread{

	private int time;

	public MyThreadWithPause(int time, String name){
		super(name);
		this.time = time;
	}

	@Override
	@SuppressWarnings("SleepWhileInLoop")
	public void run(){
		for(int i = 1; i <= 20; i++){
			System.out.printf("Running %s - Step: %d%n", getName(), i);
			try{
				System.out.printf("%s paused %d miliseconds%n", getName(), time);
				Thread.sleep(time);
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

}
