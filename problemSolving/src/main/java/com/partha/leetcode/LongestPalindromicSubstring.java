package com.partha.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author biswaspa
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(new Solution2().longestPalindrome("abbc"));
	}


	//brute force approach .
	//timecomplexity : O(n^3)
	//spaceComplexity : O(1)
	static class Solution1 {
		public String longestPalindrome(String s) {
			if(s==null)
				return null;
			if(s.length()==0)
				return "";
			String result="";
			for(int i=0;i<s.length();i++) {
				String currentString="";
				for(int j=i;j<s.length();j++) {
					boolean isPalindrome = true;
					currentString = currentString + s.charAt(j);

					for(int m=0;m<=currentString.length()/2;m++) {
						if(currentString.charAt(m)!=currentString.charAt(currentString.length()-1-m)) {
							isPalindrome = false;
							break;
						}
					}

					if(isPalindrome && result.length()<currentString.length()){
						result = currentString;
					}
				}
			}

			return result;
		}
	}


	//using dp
	//time complexity O(n^2)
	//space complexity O(n^2)
	static class Solution2{

		public String longestPalindrome(String s) {
			if(s==null)
				return null;
			if(s.length()==0)
				return "";
			//String result="";
			int maxLength = 1;
			int start = 0;
			
			int length= s.length();
			boolean[][] lps = new boolean[length][length];
			
			//populating the diagonal in the matrix
			for(int i=0;i<length;i++) {
				lps[i][i] = true;
			}
			
			
			//populating the diagonal where length=2
			for(int i=0;i<length-1;i++) {
				if(s.charAt(i)==s.charAt(i+1)) {
					lps[i][i+1] = true;
					maxLength = 2;
					start = i;
				}
			}
			
			
			//populating for substring where length>=3
			for(int i=2;i<length;i++) {
				for(int j=0;j<length-i;j++) {
					int row = j;
					int column=i+j;
					
					if(s.charAt(row)==s.charAt(column) && lps[row+1][column-1]) {
						lps[row][column] = true;
						
						if(maxLength<column - row +1) {
							maxLength = column - row +1;
							start = row;
						}
						
					}
					
				}
			}		
			return s.substring(start,start + maxLength);
		}
	}
	
	/**
	 * just like below 2 solutions . even the above solution can be shortened a little by not capturing 
	 * the start and maxLendth, but instead capture the result itself. the core logic remains the same in
	 * either case. 
	 */
	
	
	private static class Solution3 {
		int start =0;
		int maxLength=0;

		    public String longestPalindrome(String s) {
		        if (s == null || s.length() < 1) return "";
		        for (int i = 0; i < s.length(); i++) {
		            expandAroundCenter(s, i, i);
		            expandAroundCenter(s, i, i + 1);
		        }
		        return s.substring(start, start+maxLength);
		    }

		    private void  expandAroundCenter(String s, int left, int right) {
		        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
		            left--;
		            right++;
		        }
		         if(maxLength<right-left-1)
		        {
		            start=left+1;
		            maxLength=right-left-1;
		        }
		    }
		}
	
	/**
	 * same as above written in a crisper way. here instead of capturing the start and maxLength,
	 * we are capturing the palidone word itself. however the core logic remains the same as
	 */
	private static class Solution4 {

	    String result = "";

	    public String longestPalindrome(String s) {
	        for(int i=0;i<s.length();i++){
	            findPalindrome(s,i,i);
	            findPalindrome(s,i,i+1);
	        }
	        return result;
	    }

	    public void findPalindrome(String s, int start, int end){
	        while(start>=0 && end<s.length() && s.charAt(start)== s.charAt(end)){
	            result = result.length() < (end-start)+1 ?  s.substring(start,end+1): result;
	            start--;
	            end++;
	        }
	    }
	}

}
