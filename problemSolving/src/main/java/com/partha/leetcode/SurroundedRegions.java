package com.partha.leetcode;
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
	
	
	/**
	 * TC: mn
	 * sc: mn
	 * this solution uses extra space i.e. the vis array
	 * @author biswaspa
	 *
	 */
	private static class Solution1 {
	    public void solve(char[][] board) {
	       int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
	       int rows = board.length;
	       int cols = board[0].length;
	       int[][] vis = new int[rows][cols];
	       for(int row=0;row<rows;row++){
	           for(int col=0;col<cols;col++){
	               if( (row==0 || row==rows-1 || col==0 || col==cols-1 ) && board[row][col]=='O' && vis[row][col]==0){
	                    dfs(row, col , rows, cols, board, vis, dirs);
	               }
	           }
	       }

	       for(int row=0;row<rows;row++){
	           for(int col=0;col<cols;col++){
	               if(board[row][col]=='O' && vis[row][col]==0)
	                   board[row][col]='X';
	           }
	       }
	       
	    }


	    private void dfs(int row, int col, int rows, int cols, char[][] board, int[][] vis,int[][] dirs){
	        vis[row][col]=1;
	        for(int[] dir : dirs){
	            int x = row + dir[0] ; int y = col + dir[1];
	            if( x>=0 && y>=0 && x<rows-1 && y<col-1 && vis[x][y]==0 && board[row][col]=='O')
	                dfs(x, y , rows, cols, board, vis, dirs);
	        }
	    }
	}
	
	
	/**
	 * constant space . solution
	 * @author biswaspa
	 *
	 */
	private static class Solution2 {
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
