package com.partha.multithread.topic08.executors.ex11.schedulingThreadsWithExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App02FixedDelayRepeatedExecutions {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("["+ Thread.currentThread().getName() + "] started");

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		
		System.out.println("["+ Thread.currentThread().getName() + "] currentTime:"+ sdf.format(new Date()));

		executor.scheduleWithFixedDelay(new MyRunnableTask(1000), 4, 2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(15);
		executor.shutdown();
		
		System.out.println("["+ Thread.currentThread().getName() + "] completed");
	}

	public static class MyRunnableTask implements Runnable {

		private int sleepDurationInMillis;
		private static int taskid=0;


		public MyRunnableTask(int sleepDurationInMillis) {
			super();
			this.sleepDurationInMillis = sleepDurationInMillis;
		}

		private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

		@Override
		public void run() {
			Date date = new Date();
			String currentThreadName = Thread.currentThread().getName()+ ++taskid;

			System.out.println("["+ currentThreadName + "] startTime: "+sdf.format(date));
			try {
				TimeUnit.MILLISECONDS.sleep(this.sleepDurationInMillis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("["+ currentThreadName + "] endTime: "+sdf.format(date));
		}

	}

}
