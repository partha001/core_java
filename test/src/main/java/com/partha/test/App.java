package com.partha.test;


public class App 
{
    public static void main( String[] args )
    {
    	int[][] mat=new int[][]{{1,2,3},{4,5,6},{7,8,9}}; 
    	int N=2;
    	for(int x=0;x<N/2;x++){
    		for(int y=x;y<N-x-1;y++){
    			int temp= mat[x][y];
    			mat[x][y]=mat[y][N-1-x];
    			mat[y][N-1-x] = mat[N-1-x][N-1-y];
    			mat[N-1-y][N-1-y]=mat[N-1-y][x];
    			mat[N-1-y][x]= temp;
    		}
    	}
    }
    
   
}
