
package com.me.threading.intermediate;

public class RunnerNonDaemonThread extends Thread{

	private int time;
	private String name;
	
	public RunnerNonDaemonThread(int time, String name){
		setDaemon(false);
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
		RunnerNonDaemonThread nonDaemon = new RunnerNonDaemonThread(2000, "Thread 1");
		nonDaemon.start();
		try{
			Thread.sleep(4000);
		}catch(InterruptedException ex){
			System.out.println(ex.getMessage());
		}		
		System.out.println("The program is finished");
	}
	
}
