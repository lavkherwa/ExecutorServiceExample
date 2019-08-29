package com.lav;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*- Ideal pool size?
 * 
 * That depends on type of operation, 
 * so if you have IO intensive operations then
 * number of threads == no of CPU cores is ideal situation
 * 
 * */
public class Example2CPU {

	public static void main(String[] args) {

		/* This is how you can get available core counts */
		int cores = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Available cores are: " + cores);

		ExecutorService service = Executors.newFixedThreadPool(cores);

		/* Submit tasks to thread pool */
		for (int i = 0; i < 10; i++) {
			service.execute(new CpuIntensiveTask("Task " + i));
		}
	}

	static class CpuIntensiveTask implements Runnable {

		String taskName;

		public CpuIntensiveTask(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public void run() {
			System.out.println(taskName + " started");

		}
	}

}
