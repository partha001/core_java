package com.partha.problemSolving.binaryTree;

/**
 * problemStatement: count the number of binary tree possible given
 * a preorder sequence of length n
 * 
 * here dynamic programming is used to solve this 
 * @author biswaspa
 *
 */
public class CountNumberOfBinaryTreePossible {

	public static void main(String[] args) {
		System.out.println( countBT(5));
	}
	
	
	// A function to count number 
	// of binary trees with n nodes  
	static int countBT(int n) 
	{ 
		// find count of BST 
		// with n numbers 
		int count = catalan(n); 

		// return count * n! 
		return count * factorial(n); 
	} 
	
	
	
	// A Binomial coefficient  
	// based function to find  
	// nth catalan number in  
	// O(n) time 
	static int catalan( int n) 
	{ 

		// Calculate value of 2nCn 
		int c = binomialCoeff(2 * n, n); 

		// return 2nCn/(n+1) 
		return c / (n + 1); 
	}
	
	
	
	
		static int binomialCoeff(int n, 
				int k) 
		{ 
			int res = 1; 
	
			// Since C(n, k) = C(n, n-k) 
			if (k > n - k) 
				k = n - k; 
	
			// Calculate value of  
			// [n*(n-1)*---*(n-k+1)] /  
			// [k*(k-1)*---*1] 
			for (int i = 0; i < k; ++i) 
			{ 
				res *= (n - i); 
				res /= (i + 1); 
			} 
	
			return res; 
		} 



	static int factorial(int n) 
	{ 
		int res = 1; 

		// Calculate value of  
		// [1*(2)*---*(n-k+1)] /  
		// [k*(k-1)*---*1] 
		for (int i = 1; i <= n; ++i) 
		{ 
			res *= i; 
		} 

		return res; 
	} 

}
