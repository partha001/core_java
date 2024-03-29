package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/
 * @author biswaspa
 *
 */
public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * 
	 * @author biswaspa
	 * https://www.youtube.com/watch?v=B7m8UmZE-vw
	 */
	class Solution {
		public List<Integer> partitionLabels(String S) {
			List<Integer> list = new ArrayList<>();

			if(S == null || S.length() == 0){ // case 1
				return list;
			}

			if(S.length() == 1){ // case 2
				list.add(1);
				return list;
			}

			HashMap<Character, Integer> map = new HashMap<>();
			//this hashmap is to store the last occurance of each character
			for(int i = 0;i<S.length();i++){
				map.put(S.charAt(i), i);
			}
			int count = 0; int max = 0;

			for(int i = 0;i<S.length();i++){

				if(i > max){ // adding count to the resultList and then resetting it
					list.add(count);
					count = 0;
				}

				if(map.get(S.charAt(i))>=max){ //also if the lastOccurrance of the current character is > max then updating max
					max  = map.get(S.charAt(i));
				}

				count = count + 1;
			}
			list.add(count);
			return list;
		}
	}

}
