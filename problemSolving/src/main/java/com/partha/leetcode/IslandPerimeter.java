package com.partha.leetcode;

/**
 * https://leetcode.com/problems/island-perimeter
 * @author partha
 *
 */
public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution 
	{
		public int islandPerimeter(int[][] grid) 
		{
			if(grid==null || grid.length==0 || grid[0].length==0)// base case
				return 0;

			int count = 0;
			for (int i = 0; i < grid.length; i ++)
			{
				for (int j = 0; j < grid[0].length; j ++) 
				{
					if (grid[i][j] == 1) 
					{
						count += 4;
						if (j - 1 >= 0 && grid[i][j-1] == 1) // if adjacent left cell is land
							count -= 2;
						if (i - 1 >= 0 && grid[i-1][j] == 1) // if adjacent top cell is land
							count -= 2;
					}
				}
			}
			return count;
		}
	}

}
