package com.lav;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*- Ideal pool size?
 * 
 * That depends on type of operation, 
 * so if you have IO intensive operations then
 * number of threads can be kept large
 * 
 * */
public class Example3IO {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(100);

		/* Submit tasks to thread pool */
		for (int i = 0; i < 100; i++) {
			service.execute(new IoIntensiveTask("Task " + i));
		}
	}

	static class IoIntensiveTask implements Runnable {

		String taskName;

		public IoIntensiveTask(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public void run() {
			/*- some operation that cause thread  block or wait
			 * 
			 * Calling DB or another service
			 * 
			 */
			System.out.println(taskName + " started");
		}
	}

}
