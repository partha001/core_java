package com.partha.testArtifact;

/**
 * Hello world!
 *
 */
public class Application01 
{
    public static void main( String[] args )
    {
    	
       Emp emp1=new Emp("partha");
       System.out.println(emp1+"    hashcode:"+emp1.hashCode());
       Emp emp2=new Emp("partha");
       System.out.println(emp2+"    hashcode:"+emp2.hashCode());
       //conclusion1: if two employees have same name then will have same hashcode
       //since here hashcode of the employee object is calculated on the basis of empname
       
       emp1.setEmpname("saikat");
       System.out.println(emp1.hashCode());
       //conclusion2: since the hashcode of calculated on the basis of the empname
       //so when the empname of an object is updated the hashcode of the object 
       //also gets changed
       
       
       
       
       
       
       
    }
}
