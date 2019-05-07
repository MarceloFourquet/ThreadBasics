
package com.me.threading.tasks;

import java.util.concurrent.*;

public class RunnerPoolExecutor2{

	public static void main(String[] args){
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<>(), new ThreadFactoryTest(), new ThreadPoolExecutor.CallerRunsPolicy());
		executor.execute(new MyRunnable("Barcelona"));
		executor.execute(new MyRunnable("Simpson"));
		executor.execute(new MyRunnable("Bitcoin"));
		long done = 0;
		while(done != 3){
			done = executor.getCompletedTaskCount();
			System.out.printf("Completed Test: %s%n", done);
		}
		System.out.printf("Old max pool size: %s%n", executor.getMaximumPoolSize());
		executor.setMaximumPoolSize(3);
		System.out.printf("New max pool size: %s%n", executor.getMaximumPoolSize());
		executor.shutdown();
	}

}

class ThreadFactoryTest implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r){
		Thread thread = new Thread(r);
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("--- Thread Creado ---");
		return thread;
	}

}

class MyRunnable implements Runnable{

	private String keyword;

	public MyRunnable(String keyword){
		this.keyword = keyword;
	}

	@Override
	public void run(){
		for(int i = 0; i < 3; i++){
			System.out.printf("Searching for: %s%n", keyword);
		}
	}

}
