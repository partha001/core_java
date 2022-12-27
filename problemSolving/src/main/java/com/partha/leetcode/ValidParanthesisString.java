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

}
