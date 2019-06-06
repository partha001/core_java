package com.partha.designPatterns.creational.builder2;

public class OldRobotBuilder implements RobotBuilder{

	private Robot robot;
	
	public OldRobotBuilder(){
		this.robot=new Robot();
	}
	
	@Override
	public void buildRobotHead() {
		// TODO Auto-generated method stub
		robot.setRobotHead("tin head");
	}

	@Override
	public void buildRobotTorso() {
		// TODO Auto-generated method stub
		robot.setRobotTorso("tin torso");
	}

	@Override
	public void buildRobotArms() {
		// TODO Auto-generated method stub
		robot.setRobotArms("blowtorch arms");
	}

	@Override
	public void buildRobotLegs() {
		// TODO Auto-generated method stub
		robot.setRobotLegs("rollerskates legs");
	}

	@Override
	public Robot getRobot() {
		// TODO Auto-generated method stub
		return this.robot;
	}

}
