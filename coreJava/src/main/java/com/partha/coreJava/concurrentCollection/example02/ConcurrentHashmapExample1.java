package com.partha.coreJava.concurrentCollection.example02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * this program is to explore the essential methods in the concurrentHashMap
 * @author partha
 *
 */
public class ConcurrentHashmapExample1 {

	public static void main(String[] args) {
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
		map.put(100, "A");		//this will be added
		map.put(102, "B");		//this will be added
		map.putIfAbsent(103, "C");	//this will be added since key 103 is not present
		map.putIfAbsent(101, "D");	//this will not be added since key 101 is already there
		map.remove(101,"D");	//this will not remove since there is no such entry where key=101 and value=D
		map.replace(102, "B","E"); //this will replace the value for the entry whose key=102 and oldvalue=B
		System.out.println(map);
	}

}
