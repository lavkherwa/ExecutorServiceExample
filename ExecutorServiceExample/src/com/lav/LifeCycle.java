package com.lav;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LifeCycle {

	public static void main(String[] args) throws InterruptedException {

		
		ExecutorService service = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 1000000; i++) {
			service.execute(new Task("Task " + i));
		}

		/*
		 * Initiate shutdown, note it won't shutdown immediately it's just a request
		 */
		service.shutdown();

		System.out.println("is shut down? :" + service.isShutdown());

		System.out.println("is terminated?: " + service.isTerminated());

		service.awaitTermination(1, TimeUnit.SECONDS);

		List<Runnable> runnables = service.shutdownNow();
		System.out.println("Tasks pending count: " + runnables.size());

	}

	static class Task implements Runnable {

		String taskName;

		public Task(String taskName) {
			this.taskName = taskName;
		}

		@Override
		public void run() {
			System.out.println(taskName + " started");
		}

	}

}
