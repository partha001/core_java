package com.partha.designPatterns.creational.builder2;

public class Application {

	public static void main(String[] args) {
		RobotBuilder oldStyleBuilder=new OldRobotBuilder();
		//in the below line the engineer build the robot as per the specification 
		//mentioned in the oldstylerobot builder class
		RobotEngineer robotEngineer=new RobotEngineer(oldStyleBuilder);
		robotEngineer.makerobot();
		Robot firstRobot=robotEngineer.getRobot();
		System.out.println("robot built");
		System.out.println("robot head type:"+ firstRobot.getRobotHead());
		System.out.println("robot torso type:"+firstRobot.getRobotTorso());
		System.out.println("robot arm type:"+firstRobot.getRobotArms());
		System.out.println("robot leg type:"+firstRobot.getRobotLegs());
	}

}
