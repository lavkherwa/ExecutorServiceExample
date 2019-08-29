package com.lav;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example1 {

	public static void main(String[] args) {

		/*-
		 * Create a thread pool of fixed size, this will create as many threads and keep
		 * when a request comes for task execute one thread from the pool will pick the
		 * task and start
		 * 
		 * Thread pool uses blocking queue
		 */
		ExecutorService service = Executors.newFixedThreadPool(5);

		/* Submit tasks to thread pool */
		service.execute(new Task1());
		service.execute(new Task2());
		service.execute(new Task3());

		/*- Ideal pool size?
		 * 
		 * That depends on type of operation, 
		 * so if you have CPU intensive operations then
		 * number of threads = no of CPU cores is ideal situation
		 * 
		 * */
	}

	static class Task1 implements Runnable {
		@Override
		public void run() {
			System.out.println("Running task 1");

		}
	}

	static class Task2 implements Runnable {
		@Override
		public void run() {
			System.out.println("Running task 2");

		}
	}

	static class Task3 implements Runnable {
		@Override
		public void run() {
			System.out.println("Running task 3");

		}
	}
}
