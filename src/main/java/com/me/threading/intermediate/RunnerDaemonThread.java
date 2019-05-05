
package com.me.threading.intermediate;

public class RunnerDaemonThread extends Thread{

	private int time;
	private String name;

	public RunnerDaemonThread(int time, String name){
		setDaemon(true);
		this.time = time;
		this.name = name;
	}

	@Override
	@SuppressWarnings("SleepWhileInLoop")
	public void run(){
		while(true){
			try{
				System.out.printf("Is %s a daemon? - %s%n", name, isDaemon());
				sleep(time);
			}catch(InterruptedException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

	public static void main(String[] args){
		RunnerDaemonThread nonDaemon = new RunnerDaemonThread(2000, "Thread 1");
		nonDaemon.start();
		try{
			Thread.sleep(4000);
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}
		System.out.println("The program is finished");
	}

}
