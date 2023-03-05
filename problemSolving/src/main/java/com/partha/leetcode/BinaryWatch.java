package com.partha.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 * @author partha
 *
 */
public class BinaryWatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * TC O(1)
	 * @param turnedOn
	 * @return
	 */
	public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result = new ArrayList();
        for(int hour=0; hour<12; hour++){
            for(int minute=0; minute<60; minute++){
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                    if(minute<10) result.add(String.format("%d:0%d",hour,minute));
                    else result.add(String.format("%d:%d",hour,minute));
                }
            }
        }
        return result;
    }

}
