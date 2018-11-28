package com.partha.hashCodeAndEquals;

import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class Application01 
{
    public static void main( String[] args )
    {
       String s1="FB";
       String s2="Ea";
       
       System.out.println("s1 hashcode ="+s1.hashCode());
       System.out.println("s2 hashcode ="+s2.hashCode());
       
       
       System.out.println(s1.equals(s2));
       Set<String> set=new HashSet<String>();
       set.add(s1);
       set.add(s2);
       
       System.out.println(set.size());
    }
}
