package com.partha.leetcode;

public class SearchInA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//binary search on every row. this is little more time and memory consuming than solution2
	//timecomplexity : Mlogn (where m=rows and n=columns)
	private static class Solution1 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        int rows = matrix.length;
	        if(rows==0)
	            return false;
	        
	        int columns = matrix[0].length;
	        int i=0;
	        //int j=columns-1;
	        boolean found = false;
	        while(i<rows){
	            found = binarySearch(matrix[i],target,0,columns-1);
	            if(found)
	                return true;
	            i++;
	        }
	        return false;
	    }
	    
	    
	    public boolean binarySearch(int[] arr,int target,int start,int end){
	        if(start<=end){
	            int mid = (start + end )/2;
	            if(arr[mid]==target)
	                return true;
	            if(arr[mid]>target)
	                return binarySearch(arr,target,start,mid-1);
	            else
	                return binarySearch(arr,target,mid+1,end);
	        }
	        return false;
	    }
	}
	
	
	/**
	 * identifies row and then does a linear search within the row where the target can occur
	 * @author biswa
	 *
	 */
	private static class Solution2 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	       int row = 0;
	        int col = matrix[0].length - 1;
	        
	        while(row < matrix.length && col >= 0){
	            
	            if(matrix[row][col] > target){
	                //cell is greater than target,
	                //as column are increasing in order
	                //it means if go down, we will get more greater number
	                //so need to search in this column
	                col--;
	            }else if(matrix[row][col] < target){
	                //cell is less than target
	                //as rows are in increasing order
	                //there is no need to search in this row
	                //move to next row
	                row++;
	            } else {
				    //found target item
	                return true;
	            }
	        }
	        return false;
	    }
	}
	
	
	
	/**
	 * does binary search only within the row where the element can occur
	 * @author biswa
	 *
	 */
	private static class Solution3 {
	    public boolean searchMatrix(int[][] matrix, int target) {
	        int row =0;
	        int col = matrix[0].length-1;
	        while(row<matrix.length && row>=0 && col>=0 && col< matrix[0].length){
	            if(target== matrix[row][col])
	                return true;
	            else if(target> matrix[row][col])
	                row++;
	            else
	                return searchInRow(matrix[row], target, 0 ,  col);
	        }
	        return false;
	    }

	    private boolean searchInRow(int[] row, int target,int start, int end){
	        if(start>end)
	            return false;
	        int mid = (start + end)/2;
	        if(row[mid]== target)
	            return true;
	        else if(target< row[mid])
	            return searchInRow(row, target, start, mid-1);
	        return searchInRow(row, target, mid+1, end);
	        
	    }
	}
	

	

}
