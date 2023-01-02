package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/perfect-squares
 * @author biswaspa
 *
 */
public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @approach dynamic programming
	 * @source leetcode
	 * @TC O(n * squreRootOf(n) )   as the outer loop is of n iterations and the inner loop is of squareRootOf(n) iterations at most
	 * @SC O(n) 
	 * @author biswaspa
	 *
	 */
	private static class LeetcodeOfficialSolution2 {

		  public int numSquares(int n) {
		    int dp[] = new int[n + 1];
		    Arrays.fill(dp, Integer.MAX_VALUE);
		    // bottom case
		    dp[0] = 0;

		    // pre-calculate the square numbers.
		    int max_square_index = (int) Math.sqrt(n) + 1;
		    int square_nums[] = new int[max_square_index];
		    for (int i = 1; i < max_square_index; ++i) {
		      square_nums[i] = i * i;
		    }

		    for (int i = 1; i <= n; ++i) {
		      for (int s = 1; s < max_square_index; ++s) {
		        if (i < square_nums[s])
		          break;
		        dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
		      }
		    }
		    return dp[n];
		  }
		}
	
	
	/**
	 * @approach greedy enumeration
	 * @source leetcode
	 * TC and SC  refer to https://leetcode.com/problems/perfect-squares/solutions/406607/perfect-squares/ 
	 * or https://drive.google.com/file/d/1NCvqkiSumBIRuWMBnDALqKkmg9XJjMwL/view?usp=share_link
	 * @author biswaspa
	 *
	 */
	private static class  LeetcodeOfficialSolutio3 {
		  Set<Integer> square_nums = new HashSet<Integer>();

		  protected boolean is_divided_by(int n, int count) {
		    if (count == 1) {
		      return square_nums.contains(n);
		    }

		    for (Integer square : square_nums) {
		      if (is_divided_by(n - square, count - 1)) {
		        return true;
		      }
		    }
		    return false;
		  }

		  public int numSquares(int n) {
		    this.square_nums.clear();

		    for (int i = 1; i * i <= n; ++i) {
		      this.square_nums.add(i * i);
		    }

		    int count = 1;
		    for (; count <= n; ++count) {
		      if (is_divided_by(n, count))
		        return count;
		    }
		    return count;
		  }
		}
	
	
	/**
	 * @approach greedy + breadth fist search
	 * @source leetcode
	 * TC and SC  refer to https://leetcode.com/problems/perfect-squares/solutions/406607/perfect-squares/ 
	 * 		or https://drive.google.com/file/d/1NCvqkiSumBIRuWMBnDALqKkmg9XJjMwL/view?usp=share_link
	 * @author biswaspa
	 *
	 */
	private static class  LeetcodeOfficialSolutio4  {
		  public int numSquares(int n) {

		    ArrayList<Integer> square_nums = new ArrayList<Integer>();
		    for (int i = 1; i * i <= n; ++i) {
		      square_nums.add(i * i);
		    }

		    Set<Integer> queue = new HashSet<Integer>();
		    queue.add(n);

		    int level = 0;
		    while (queue.size() > 0) {
		      level += 1;
		      Set<Integer> next_queue = new HashSet<Integer>();

		      for (Integer remainder : queue) {
		        for (Integer square : square_nums) {
		          if (remainder.equals(square)) {
		            return level;
		          } else if (remainder < square) {
		            break;
		          } else {
		            next_queue.add(remainder - square);
		          }
		        }
		      }
		      queue = next_queue;
		    }
		    return level;
		  }
		}

	
	/**
	 * @approach Mathematics
	 * @source leetcode
	 * TC and SC  refer to https://leetcode.com/problems/perfect-squares/solutions/406607/perfect-squares/ 
	 * 		or https://drive.google.com/file/d/1NCvqkiSumBIRuWMBnDALqKkmg9XJjMwL/view?usp=share_link
	 * @author biswaspa
	 *
	 */
	private static class  LeetcodeOfficialSolution5 {

		  protected boolean isSquare(int n) {
		    int sq = (int) Math.sqrt(n);
		    return n == sq * sq;
		  }

		  public int numSquares(int n) {
		    // four-square and three-square theorems.
		    while (n % 4 == 0)
		      n /= 4;
		    if (n % 8 == 7)
		      return 4;

		    if (this.isSquare(n))
		      return 1;
		    // enumeration to check if the number can be decomposed into sum of two squares.
		    for (int i = 1; i * i <= n; ++i) {
		      if (this.isSquare(n - i * i))
		        return 2;
		    }
		    // bottom case of three-square theorem.
		    return 3;
		  }
		}
}
