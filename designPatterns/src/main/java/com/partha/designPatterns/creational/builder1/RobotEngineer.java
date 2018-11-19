package com.partha.designPatterns.creational.builder1;

public class RobotEngineer {


	//w.r.t the design patten it is often reffered to as the director class	
	private RobotBuilder robotBuilder;

	public RobotEngineer(RobotBuilder robotBuilder){
		this.robotBuilder=robotBuilder;
	}

	public Robot getRobot(){
		return this.robotBuilder.getRobot();
	}

	public void makerobot(){
		this.robotBuilder.buildRobotHead();
		this.robotBuilder.buildRobotTorso();
		this.robotBuilder.buildRobotArms();
		this.robotBuilder.buildRobotLegs();

	}

}
