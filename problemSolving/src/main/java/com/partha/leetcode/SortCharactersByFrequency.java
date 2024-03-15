package com.partha.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * problem statement: https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private static class Solution1 {
		public String frequencySort(String s) {
			int[]freq=new int[128];
			for(char ch:s.toCharArray()){
				freq[ch]++;
			}
			char[]c=new char[s.length()];
			for(int i=0;i<s.length();){
				int max=0;
				int index=0;
				for(int j=0;j<128;j++){
					if(freq[j]>max){
						max=freq[j];
						index=j;
					}
				}
				while(freq[index]>0){
					c[i++]=(char)index;
					freq[index]--;
				}
			}
			return new String(c);
		}
	}


	private static class Solution2 {
		public String frequencySort(String s) {
			String t="";
			Map<Character,Integer>map=new TreeMap<>();
			List<Character>ch=new ArrayList<>();
			for(int i=0;i<s.length();i++){
				map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
				ch.add(s.charAt(i));
			}

			Collections.sort(ch, (a, b) -> {
				int freqDiff = map.get(b) - map.get(a);
				if(freqDiff == 0) {
					return b - a;
				}   
				return freqDiff;
			});


			for(int i=0;i<ch.size();i++){
				t=t+ch.get(i);
			}

			return t;
		}
	}



	/**
	 * using Map.Entry instead of the pair class
	 * @author partha
	 *
	 */
	private static class Solution3 {
		public String frequencySort(String s) {
			HashMap<Character, Integer> hm = new HashMap<>();

			// adding all chars to a hashmap
			for(int i=0;i<s.length();i++)
				hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);

			Map.Entry<Character,Integer>[] arr = new  Map.Entry[hm.size()];
			int k=0;
			for (Map.Entry<Character, Integer> entry : hm.entrySet())
			{
				arr[k] = Map.entry(entry.getKey(), entry.getValue());
				k++;
			}

			// sorting this array based on the count of each character
			Arrays.sort(arr,(a, b) -> b.getValue() - a.getValue());
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<arr.length;i++){
				for(int j=0;j<arr[i].getValue();j++){
					sb.append(arr[i].getKey());
				}
			}
			return sb.toString();

		}
	}
	




	/**
	 * bucket sort using hashMap
	 * @author partha
	 *
	 */
	private static class Solution4 {
		public String frequencySort(String s) {
			Map<Character, Integer> map = new HashMap<>();
			for (char c : s.toCharArray())  //putting all characters with their frequency
				map.put(c, map.getOrDefault(c, 0) + 1);

			List<Character> [] bucket = new List[s.length() + 1]; // formed an array of type arraylist.
			//in this Array the frequency in the index of the array . thus if s=aacc then arr[2]= {a,c}


			for (char key : map.keySet()) { //traversing map to get frquency.
				int frequency = map.get(key);  //getting freq. of char
				if (bucket[frequency] == null) 
					bucket[frequency] = new ArrayList<>(); //in place of freq.  in bucket initializing with empty arraylist
				bucket[frequency].add(key); // and adding char at freq. position
			}

			StringBuilder sb = new StringBuilder(); 
			for (int pos = bucket.length - 1; pos >= 0; pos--) //cause we have to print higher freq. char 1st
				if (bucket[pos] != null) //index where char exist
					for (char c : bucket[pos])  //accesing the char
						for (int i = 0; i < pos; i++)  // accesing char freq. times
							sb.append(c); // storing them in sb

			return sb.toString(); //convert sb to string as per our return type
		}
	}

}
