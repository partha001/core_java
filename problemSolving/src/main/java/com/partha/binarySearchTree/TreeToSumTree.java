package com.partha.binarySearchTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * https://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * @author biswaspa
 *
 */
public class TreeToSumTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = new int[] {3,2,1};
//		Arrays.asList(arr).stream().max(arg0)
//		Arrays.sort(arr);
//		System.out.println(arr);
		hurdleRace(4,new int[] {1, 6 ,3 ,5 ,2});
		
	}
	
	
	 // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        if(height.length==0){
            return 0;
        }
        
        int maxHeight = height[0];
        for(int i=1;i<height.length;i++){
           if(height[i]>maxHeight)
               maxHeight = height[i];
        }
        
        if(maxHeight>k){
            return maxHeight-k;
        }else{
            return 0;
        }

    }
	
//	static int migratoryBirds(List<Integer> arr) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for(Integer i: arr){
//            map.put(i,map.get(i)==null ? 1 : map.get(i).intValue()+1);
//        }
//        
//        if(arr.si==0){
//            return 0;
//        }else{
//            int maxId = arr.get(0);
//            int maxCount = map.get(maxId);
//            
//            for(Integer i: map.keySet()){
//                
//            }
//            
//            
//        }
//
//    }

}
