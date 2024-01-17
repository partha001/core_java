package com.partha.multithread.topic09.threadlocal.ex05;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;


/**
 * this program shows how the userObject available and accessed by all underlying service methods that are running 
 * within a thread. and finally in the end we clear our the userContext in the last service/task of each thread.
 * 
 * 1.thus we dont need to pass the userDetails from one service to other explicilty
 * 
 * 2. the userObject also remains isolated for each thread. 
 * @author biswa
 *
 */
public class Application05 {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread(()->{
			try {
				User user = User.builder()
						.userId(1)
						.name("partha")
						.build();
				UserUtil.userContext.set(user);
				new Service1().print();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		
		new Thread(()->{
			try {
				User user = User.builder()
						.userId(2)
						.name("anuradha")
						.build();
				UserUtil.userContext.set(user);
				new Service1().print();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}



}

@Data
@Builder
class User {
	int userId;
	String name;
}


//here we are putting the threadLocal in a separate class
class UserUtil {
	public static ThreadLocal<User> userContext = new ThreadLocal<User>();
}



class Service1 {

	void print() throws InterruptedException {
		System.out.println("Service1.print() :: performing some task");
		Thread.sleep(3000);
		System.out.println(UserUtil.userContext.get().toString());
		new Service2().print();
	}
}



class Service2 {
	void print() throws InterruptedException {
		System.out.println("Service2.print() :: performing some task");
		Thread.sleep(3000);
		System.out.println("Service2.print() :: " + UserUtil.userContext.get().toString());
		new Service3().print();
	}
}


class Service3 {
	void print() throws InterruptedException {
		System.out.println("Service3.print() :: performing some task");
		Thread.sleep(3000);
		System.out.println(UserUtil.userContext.get().toString());
		System.out.println("Service3.print() :: crealring our user details");
		UserUtil.userContext.remove();
		System.out.println("Service3.print() :: fetching usercontext after clearing:"+ UserUtil.userContext.get());
	}
}

