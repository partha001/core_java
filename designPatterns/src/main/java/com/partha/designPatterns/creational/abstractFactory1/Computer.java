package com.partha.designPatterns.creational.abstractFactory1;

/**
 * this is declared as an abstract class so that it cant be instantiated directly
 * @author partha
 *
 */
public abstract class Computer {
	
	public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
     
    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }

}
