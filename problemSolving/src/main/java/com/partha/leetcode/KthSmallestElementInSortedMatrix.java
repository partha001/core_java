package com.partha.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * @author biswaspa
 *
 */
public class KthSmallestElementInSortedMatrix {

	public static void main(String[] args) {
		new Solution2().kthSmallest(new int[][] {{1,2,3,},{4,5,6},{7,8,9}}, 8);
	}
	
	
	/**
	 * brute force
	 * timecomplexity : n^2 + nLogn  = n^2
	 * @author biswaspa
	 *
	 */
	static class Solution1 {
	    public int kthSmallest(int[][] matrix, int k) {
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        int[] arr = new int[rows*columns];
	        
	        int a=0;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                arr[a++] = matrix[i][j];
	            }
	        }
	        Arrays.sort(arr);
	        return arr[k-1];
	    }
	}
	
	
	/**
	 * https://www.youtube.com/watch?v=G5wLN4UweAM
	 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/394294/Using-Binary-Search-in-Java-and-analysis
	 * binary search solution
	 * @timeComplexity : O(n log (n^2)).
	 * @author biswaspa
	 *
	 */
	 static class Solution2 {
		  public int kthSmallest(int[][] matrix, int k) {
	        int n = matrix.length;
	        int left = matrix[0][0];
	        int right = matrix[n-1][n-1];
	        
	        int result = 0;
	        while (left <= right){
	            int mid = left + (right - left) / 2;
	            int count = countSmallerThanMid(mid, matrix);
	            if (count < k)
	                left = mid + 1;
	            else
	                right = mid - 1;
	        }
	        return left;
	    }
	    
	    // count how many elements are there lesser than the mid
	    private int countSmallerThanMid(int mid, int[][] matrix){
	        int n  = matrix.length;
	        int j = n-1;
	        int count = 0;
	        
	        for (int i=0;i<n;i++){
	            while (j >= 0 && matrix[i][j] > mid)
	                j--;
	            count += j+1;
	        }
	        return count;
	    }
	    
	}
	 
	 
	/**
	 *  
	 * @author biswaspa
	 *
	 */
	 static class Solution3 {
		    
		    public class Element implements Comparable<Element>{
		        int row,col,val;
		        
		        public Element(int row, int col, int val){
		            this.row = row;
		            this.col = col;
		            this.val = val;
		        }
		        
		        @Override
		        public int compareTo(Element e){
		            return this.val - e.val;
		        }
		    }
		    
		    public int kthSmallest(int[][] matrix, int k) {
		        
		        PriorityQueue<Element> q = new PriorityQueue<Element>();
		        
		        //add first row into the priority queue
		        for(int i=0;i<matrix[0].length;i++)
		            q.add(new Element(0,i, matrix[0][i]));
		        
		        for(int i=0;i<k-1;i++){
		            Element e = q.poll();
		            if (e.row+1 < matrix.length)
		                q.add(new Element(e.row+1, e.col, matrix[e.row+1][e.col]));    
		        }
		        
		        return q.peek().val;
		    }
		}

}
