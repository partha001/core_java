package com.partha.problemSolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * @author partha
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * howerver here the heapify operation in the priority queue will increase the time complexity
	 * @author partha
	 *
	 */
	private static class Solution1 {

		public int[] topKFrequent(int[] nums, int k) {
			int[] result = new int[k];
			if(nums.length==0)
				return result;
			Map<Integer,Integer> map = new HashMap();
			for(int i=0;i<nums.length;i++)
				map.put(nums[i], map.get(nums[i])==null? 1: map.get(nums[i])+1 );

			Queue<Element> queue = new PriorityQueue<Element>( (a ,b) -> b.frequency - a.frequency);
			for(Integer key:map.keySet()){
				Element element = new Element();
				element.number = key;
				element.frequency = map.get(key);
				queue.add( element);
			}

			for(int i=0;i<k;i++){
				result[i] = queue.poll().number;
			}

			return result;

		}


		class Element {
			int number;
			int frequency;
		}         

	}


	/**
	 * https://www.youtube.com/watch?v=YPTqKIgVk-k
	 * timeComplexity : O(n)
	 * @author partha
	 *
	 */
	private static class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			Map<Integer,Integer> map =new HashMap();
			for(int i =0;i<nums.length ;i++){
				map.put(nums[i], map.getOrDefault(nums[i],0) +1);
			}

			List<Integer>[]  bucket = new List[nums.length+1]; //in this array frequency is the index
			for(Integer element : map.keySet()){
				int frequency = map.get(element);
				List<Integer> sublist = bucket[frequency];
				if(sublist==null) 
					sublist = new ArrayList<Integer>();
				sublist.add(element);
				bucket[frequency] = sublist;
			}

			int[] result = new int[k];
			int currentElement = 0;
			
			//now scanning each bucket to load to result till we add k elements
			for(int i=bucket.length-1;i>=0;i--){
				if(bucket[i]== null)
					continue;
				for(int n: bucket[i]){
					result[currentElement++] = n;
					if(currentElement == k)
						return result;
				}
			}
			return result;
		}
	}

}
