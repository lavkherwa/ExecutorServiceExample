package com.lav;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(100);

		/* Submit tasks to thread pool */
		@SuppressWarnings("rawtypes")
		List<Future> allFutures = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<String> future = service.submit(new Task("Task " + i));
			allFutures.add(future);
		}

		for (Future<String> future : allFutures) {

			/*- If you want the operation to be completed in a specified time
			 * 
			 *  future.get(1, TimeUnit.SECONDS);
			 * 
			 */

			System.out.println("==> " + future.get());
		}
	}

	static class Task implements Callable<String> {

		String taskName;

		public Task(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public String call() throws Exception {
			return taskName + " started";
		}
	}

}
