package com.partha.leetcode.lld;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * @author partha
 *
 */
public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		
	}

	private static class RandomizedSet {
	    
	    int[] arr= new int[100001];
	    Map<Integer,Integer> map ;
	    int currentIndex = 0;
	    Random random = new Random();
	    
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        map = new HashMap<Integer,Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val))
	            return false;
	        arr[currentIndex] = val;
	        map.put(val,currentIndex);
	        currentIndex++;
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(map.get(val)==null)
	            return false;
	        
	        int removeIndex = map.remove(val);
	        //swapping last element with the removed element   
	        arr[removeIndex] = arr[currentIndex-1];         
	        if(map.containsKey(arr[currentIndex-1])){   
	            map.put(arr[currentIndex-1],removeIndex);
	        }
	        currentIndex--;
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        
	        return arr[random.nextInt(currentIndex)];
	    }
	}
	
	
	
	private static class RandomizedSet2 {

	    Set<Integer> randomSet;
	        
	    public RandomizedSet2() {
	        randomSet = new HashSet<>();
	    }
	    
	    public boolean insert(int val) {
	        if (randomSet.contains(val)) {
	            return false;
	        }
	        randomSet.add(val);
	        return true;
	    }
	    
	    public boolean remove(int val) {
	        if (randomSet.contains(val)) {
	            randomSet.remove(val);
	            return true;
	        }
	        return false;
	    }
	    
	    public int getRandom() {
	        Integer[] numbers = randomSet.toArray(new Integer[randomSet.size()]);
	        Random random = new Random();
	        int randomNumber = random.nextInt(randomSet.size());
	        return numbers[randomNumber];
	    }
	}


}
