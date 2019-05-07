
package com.me.threading.tasks;

import java.util.concurrent.*;

public class RunnerPoolExecutor1{

	public static void main(String[] args){
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 100, TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
		executor.execute(new MyRunnable1("Java"));
		executor.execute(new MyRunnable1("Scala"));
		executor.execute(new MyRunnable1("C#"));
		System.out.printf("Old max pool size: %s%n", executor.getMaximumPoolSize());
		executor.setMaximumPoolSize(4);
		System.out.printf("New max pool size: %s%n", executor.getMaximumPoolSize());
		executor.shutdown();
	}

}

class MyRunnable1 implements Runnable{

	private String keyword;

	public MyRunnable1(String keyword){
		this.keyword = keyword;
	}

	@Override
	public void run(){
		for(int i = 0; i < 3; i++){
			System.out.printf("Searching for: %s%n", keyword);
		}
	}

}
