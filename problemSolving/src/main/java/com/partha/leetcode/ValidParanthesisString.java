package com.partha.leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string
 * @author partha
 *
 */
public class ValidParanthesisString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	/**
	 * https://www.youtube.com/watch?v=QhPdNS143Qg
	 */
	private static class Solution1 {
		public boolean checkValidString(String s) {
			int leftMin =0;
			int leftMax =0;
			for(char c:s.toCharArray()){
				if(c=='('){
					leftMin++;
					leftMax++;
				}else if(c==')'){
					leftMin--;
					leftMax--;
				}else{
					leftMin--;
					leftMax++;
				} 
				if(leftMax<0)
					return false;

				//below is to handle s= (*)(
				//if we dont add this then we will end up returning true
				if(leftMin<0)  
					leftMin=0;

			}

			if(leftMin==0)
				return true;

			return false;
		}
	}
	
	/**
	 * practice this solution. its basically same as above just written in a different way
	 * @author partha
	 * @source leetcode official solution
	 * @algorithm Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.<br>
	 * If we encounter a left bracket (c == '('), then lo++, otherwise we could write a right bracket, so lo--. If we encounter what can be a left bracket (c != ')'), 
	 * then hi++, otherwise we must write a right bracket, so hi--. If hi < 0, then the current prefix can't be made valid no matter what our choices are. Also, we can
	 *  never have less than 0 open left brackets. At the end, we should check that we can have exactly 0 open left brackets.
	 */
	private static class Solution {
	    public boolean checkValidString(String s) {
	       int lo = 0, hi = 0;
	       for (char c: s.toCharArray()) {
	           lo += c == '(' ? 1 : -1;
	           hi += c != ')' ? 1 : -1;
	           if (hi < 0) break;  //breaking out since it cant be recovered
	           lo = Math.max(lo, 0);
	       }
	       return lo == 0;
	    }
	}

}
