
package com.me.threading.tasks;

import java.util.concurrent.*;

public class RunnerSingleExecutor1{

	public static void main(String[] args){
		ExecutorService exService = Executors.newSingleThreadExecutor();
		Future<Integer> callFuture1 = exService.submit(new RunnerSingleExecutor1().new MyCallable1("Callable 1"));
		Future<Integer> callFuture2 = exService.submit(new RunnerSingleExecutor1().new MyCallable1("Callable 2"));
		try{
			System.out.println("Callable 1: " + callFuture1.get());
			System.out.println("Callable 2: " + callFuture2.get());
			System.out.println("isTerminated: " + exService.isTerminated());
			exService.awaitTermination(5, TimeUnit.SECONDS);
			exService.shutdown();
			System.out.println("Program is finished");
		}catch(InterruptedException | ExecutionException ex){
			System.out.println(ex.getMessage());
		}
	}

	class MyCallable1 implements Callable<Integer>{

		private String name;

		public MyCallable1(String name){
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

}
