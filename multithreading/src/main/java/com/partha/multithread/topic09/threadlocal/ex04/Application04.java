package com.partha.multithread.topic09.threadlocal.ex04;

import lombok.Builder;
import lombok.Data;

/**
 * this program shows how we have moved threadLocal to a differeent class and how to set values in the threadLocal
 * and the value set in the threadLocal is accessible from anywhere sitting on the particular thread
 * and finally how the value can be cleared
 * @author biswa
 *
 */
public class Application04 {

	public static void main(String[] args) {
		new Thread(() ->{

			try {
				System.out.println(UserUtil.userContext.get());
				User user1 = User.builder()
						.userId(1)
						.name("partha")
						.build();
				UserUtil.userContext.set(user1);
				System.out.println(UserUtil.userContext.get());


				//this delay is to simulate some task
				Thread.sleep(5000);
				
				//finally clearing out user details
				System.out.println("now clearing out user details from the threadlocal");
				UserUtil.userContext.remove();
				System.out.println(UserUtil.userContext.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
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
