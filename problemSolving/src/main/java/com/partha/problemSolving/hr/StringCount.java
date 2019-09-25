package com.partha.problemSolving.hr;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * problemDefinition: https://www.hackerrank.com/challenges/sparse-arrays/problem
 * @author partha
 *
 */
public class StringCount {

	public static void main(String[] args) {
		String[] strings = new String[]{"abcde", "sdaklfj", "asdjf","na","basdn","sdaklfj","asdjf","na","asdjf","na","basdn","sdaklfj","asdjf"};
		String[] queries = new String[]{"abcde","sdaklfj","asdjf","na","basdn"};
		int[] results= matchingStrings(strings, queries);
		IntStream.range(0, results.length)
					.forEach(i-> System.out.println(results[i]));
	}
	
	static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String,Integer> map=new HashMap<String,Integer>();

        for(int i=0;i<strings.length;i++){
            map.put(strings[i], map.keySet().contains(strings[i]) ? map.get(strings[i])+1 :1);
        }
        
        int[] count = new int[queries.length];
        for(int i=0;i<queries.length;i++){
        	if(map.keySet().contains(queries[i])){
        		count[i]=map.get(queries[i]);
        	}else{
        		count[i]=0;
        	}
        }
        
        return count;

    }

}
