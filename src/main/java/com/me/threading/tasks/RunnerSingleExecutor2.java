
package com.me.threading.tasks;

import java.util.concurrent.*;

public class RunnerSingleExecutor2{

	public static void main(String[] args){
		ExecutorService exService = Executors.newFixedThreadPool(2);
		Future<String> runFuture = exService.submit(new MyRunnable2("Callable 1"), "done");
		Future<Integer> callFuture = exService.submit(new MyCallable2("Callable 2"));
		try{
			System.out.println("Runnable: " + runFuture.get());
			System.out.println("Callable: " + callFuture.get());
			System.out.println("isTerminated: " + exService.isTerminated());
			exService.awaitTermination(5, TimeUnit.SECONDS);
			exService.shutdown();
			System.out.println("Program is finished");
		}catch(InterruptedException | ExecutionException ex){
			System.out.println(ex.getMessage());
		}
	}

}

class MyCallable2 implements Callable<Integer>{

	private String name;

	public MyCallable2(String name){
		this.name = name;
	}

	@Override
	public Integer call(){
		int count = 0;
		for(; count < 5; count++){
			System.out.printf("%s - Step: %d%n", name, count);
		}
		return count;
	}

}

class MyRunnable2 implements Runnable{

	private String name;

	public MyRunnable2(String name){
		this.name = name;
	}

	@Override
	public void run(){
		for(int count = 0; count < 5; count++){
			System.out.printf("%s - Step: %d%n", name, count);
		}
	}

}
