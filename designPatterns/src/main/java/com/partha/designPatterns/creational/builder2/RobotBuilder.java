package com.partha.designPatterns.creational.builder2;

public interface RobotBuilder {

	public void buildRobotHead();

	public void buildRobotTorso();

	public void buildRobotArms();

	public void buildRobotLegs();

	public Robot getRobot();


}
