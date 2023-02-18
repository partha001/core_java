package com.partha.leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/exam-room/
 * @author partha
 *
 */
public class ExamRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static class ExamRoom1 {

	     int capacity; // this is just to keep track of the max allowed size
	    TreeSet<Integer> seats; 
	    
	    public ExamRoom1(int n) {
	        this.capacity=n;
	        this.seats = new TreeSet<>();
	    }
	    
	    public int seat() {
	        int seatNumber=0;
	        if(seats.size() > 0){
	            Integer prev=null;
	            int distance = seats.first();
	            for(Integer seat : seats){
	                if(prev != null){
	                    int d = (seat-prev)/2;
	                    if(distance < d){
	                        distance=d;
	                        seatNumber=prev+distance;
	                    }
	                }
	                prev = seat;
	            }
	            
	            if(distance < capacity-1-seats.last()){
	                seatNumber = capacity-1;
	            }
	        }
	        seats.add(seatNumber);
	        return seatNumber;
	    }
	    
	    public void leave(int p) {
	        seats.remove(p); 
	    }
	}


}
