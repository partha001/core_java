package com.partha.problemSolving.leetcode;

/**
 * @link : https://leetcode.com/problems/reverse-integer/
 * @author biswaspa
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
//		int y = 964632435;
//		System.out.println(y*10);
		//System.out.println(obj.reverse(1534236469));
	}
	
	public int reverse(int x) {
		int rev = 0;
	      //System.out.println("Original: " + i);
	      while(x != 0) {
	         int digit = x % 10;
	         rev = rev * 10 + digit;
	         x /= 10;
	      }
	      return rev;
	}
	
//	 public int reverse(int x) {
//	    int rev = 0;
//		while (x != 0) {
//			if (Math.abs(rev) > Integer.MAX_VALUE / 10
//					|| Math.abs(rev) == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10)
//				return 0;
//			rev = rev * 10 + x % 10;
//			x = x / 10;
//		}
//		return rev;
//	    }
	
//	1534236469 -- input
//	9646324351 -- expected output
//	964632435  -- ok till this
//	964632435	
	
//	public int reverse(int x) {
//        if(x<=9 && x>=-9){
//           return x*(-1);
//        }else{
//            String s = "" ;
//            char[] arr=(""+x).toCharArray();
//            if(x>0){
//                for(int i=arr.length-1;i>=0;i--){
//                    s+=arr[i];
//                }
//            }else{
//                for(int i=arr.length-1;i>=1;i--){
//                    s+=arr[i];
//                }
//            }
//            return (new Integer(s)).intValue()*-1;
//            //return result*(-1);
//        }
//    }

}
