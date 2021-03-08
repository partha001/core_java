package com.partha.problemSolving.leetcode;
/**
 * https://leetcode.com/problems/surrounded-regions/
 * @author biswaspa
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		new Solution1().solve(board);
	}
	
	
	private static class Solution1 {
	    int rows;
	    int columns;
	    
	    //int[] arri =  new int[]{0,-1,-1,-1,0,1,1,1};
	    //int[] arrj =  new int[]{-1,-1,0,1,1,1,0,-1};
	    
	    int[] arri = new int[]{0,-1,0,1};
	    int[] arrj = new int[]{-1,0,1,0};
	    
	    public void solve(char[][] board) {
	        rows = board.length;
	        if(rows==0)
	            return ;
	        
	        columns = board[0].length;
	        //marking the not surrounded ones with a different character
	        
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(board[i][j]=='O' && liesOnBoundary(i,j)){
	                    transform(board,i,j);
	                }                   
	            }
	        }
	        
	        
	        
	        
	         for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(board[i][j]=='O')
	                    board[i][j]='X';
	            }
	         }
	        
	        
	        
	         for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(board[i][j]=='*')
	                    board[i][j]='O';
	            }
	         }
	    }
	    
	    
	    private void transform(char[][] board,int i,int j){
	        board[i][j] = '*';
	        for(int m=0;m<4;m++){
	            int a = i+ arri[m];
	            int b = j+ arrj[m];
	            if(isValidCoordinate(a,b) && board[a][b]=='O')
	                transform(board,a,b);
	        }
	    }
	    
	    private boolean liesOnBoundary(int i,int j){
	        if(i==0 || i==rows-1 || j==0 || j==columns-1)
	            return true;
	        return false;
	    }
	    
	    
	    private boolean isValidCoordinate(int i,int j){
	        if(i>=0 && i<rows && j>=0 && j<columns)
	            return true;
	        return false;
	    }
	    
	    
	    
	}

}
