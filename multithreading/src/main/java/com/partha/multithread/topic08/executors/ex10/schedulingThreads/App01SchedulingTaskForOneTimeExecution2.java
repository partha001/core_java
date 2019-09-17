package com.partha.multithread.topic08.executors.ex10.schedulingThreads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class App01SchedulingTaskForOneTimeExecution2 {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");

	public static void main(String[] args) throws InterruptedException {
		System.out.println("["+Thread.currentThread().getName()+ "]  started" );

		//by passing true we have chosen to run the timer thread in a daemon mode
		Timer timer = new Timer("Timer-thread",false);
		
		/***************** first task ******************/
		//scheduling by providing the exact time to run		
		Date currentTime = new Date();
		Date scheduledTime =  getFutureTime(currentTime, 1000);
		System.out.println("["+Thread.currentThread().getName()+ 
								"]  task1-details currentTime:"+sdf.format(currentTime) + 
								"   scheduledTime:"+ sdf.format(scheduledTime));
		timer.schedule(new MyTask("task1",5000), scheduledTime);
		
		
		/***************** second task ******************/
		//scheduling by providing the offset in milliseconds from the current time	
		MyTask myTask2 = new MyTask("task2",2000);
		timer.schedule(myTask2, 2000);
		System.out.println("["+Thread.currentThread().getName()+ 
				"]  task2-details currentTime:"+sdf.format(currentTime) + 
				"   scheduledTime:"+ sdf.format(myTask2.scheduledExecutionTime()));
		
		// to terminate the timer ourselves
//		TimeUnit.MILLISECONDS.sleep(8000);
//		timer.cancel();
			
		System.out.println("["+Thread.currentThread().getName()+ "]  completed" );
	}
	
	
	public static Date getFutureTime(Date initialTime, long millisToAdd){
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(initialTime.getTime()+ millisToAdd);
		return cal.getTime();
	}

	
	public static class MyTask extends  TimerTask {
		
		private String taskId;
		private long taskDurationInMillis;

		private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
		
		public MyTask(String taskId,long taskDurationInMillis) {
			super();
			this.taskId = taskId;
			this.taskDurationInMillis = taskDurationInMillis;
		}

		@Override
		public void run() {

			Date starttime = new Date();
			Date scheduledForRunningTime  = new Date(super.scheduledExecutionTime());

			System.out.println("["+ taskId + 
					"]  actualStartTime:"+sdf.format(starttime) +
					"  scheduled-time:"+ sdf.format(scheduledForRunningTime));

			try{
				TimeUnit.MILLISECONDS.sleep(taskDurationInMillis);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}

			System.out.println("["+ taskId + "]  completed at:"+ sdf.format(new Date()));
		}

	}

}
