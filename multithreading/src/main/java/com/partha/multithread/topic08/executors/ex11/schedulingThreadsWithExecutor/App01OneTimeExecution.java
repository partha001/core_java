package com.partha.multithread.topic08.executors.ex11.schedulingThreadsWithExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class App01OneTimeExecution {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("["+ Thread.currentThread().getName() + "] started");

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		System.out.println("["+ Thread.currentThread().getName() + "] currentTime:"+ sdf.format(new Date()));

		ScheduledFuture<?> future1 = executor.schedule(new MyRunnableTask(0), 4, TimeUnit.SECONDS);
		ScheduledFuture<Integer> future2 = executor.schedule(new MyCallableTask(10, 20, 2000), 6, TimeUnit.SECONDS);
		ScheduledFuture<?> future3 = executor.schedule(new MyRunnableTask(0), 8, TimeUnit.SECONDS);
		ScheduledFuture<Integer> future4 = executor.schedule(new MyCallableTask(10, 20, 2000), 6, TimeUnit.SECONDS);


		executor.shutdown();
		
		//uncomment the below line and see the result
		//future1.cancel(true);

		System.out.println("["+ Thread.currentThread().getName() + "] retrieving results now ");

		System.out.println("["+ Thread.currentThread().getName() + "] task-result1:"+future1.get());
		System.out.println("["+ Thread.currentThread().getName() + "] task-result2:"+future2.get());
		System.out.println("["+ Thread.currentThread().getName() + "] task-result3:"+future3.get());
		System.out.println("["+ Thread.currentThread().getName() + "] task-result4:"+future4.get());

		System.out.println("["+ Thread.currentThread().getName() + "] completed");
	}


	public static class MyCallableTask implements Callable<Integer> {

		private int a;
		private int b;
		private int sleepDurationInMillis;
		private static int taskid = 1;
		private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

		public MyCallableTask(int a, int b,int sleepDurationInMillis) {
			super();
			this.a = a;
			this.b = b;
			this.sleepDurationInMillis = sleepDurationInMillis;
		}

		@Override
		public Integer call() throws Exception {
			Date date = new Date();
			String currentThreadName = Thread.currentThread().getName()+ ++taskid;

			System.out.println("["+ currentThreadName + "] startTime: "+sdf.format(date));
			TimeUnit.MILLISECONDS.sleep(this.sleepDurationInMillis);
			System.out.println("["+ currentThreadName + "] endTime: "+sdf.format(date));

			return this.a+ this.b;
		}	

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
