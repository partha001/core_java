package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/alien-dictionary/
 * @author partha
 *
 */
public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * approach : BFS
	 * source : leetcode official solution
	 * link https://leetcode.com/problems/alien-dictionary/solutions/562919/alien-dictionary/
	 * @author partha
	 * @TC: O(C) where C is the total length of all the words in the input.
	 * @SC: O(1) or O(U+min⁡(U^2,N))  where N=total number of strings in the input list. and U=Total number of letters in alphabet series alphabets 
	 */
	private static class LeetcodeOfficialSolution1 {
		public String alienOrder(String[] words) {

			// Step 0: Create data structures and find all unique letters.
			Map<Character, List<Character>> adjList = new HashMap<>();
			Map<Character, Integer> counts = new HashMap<>();
			for (String word : words) {
				for (char c : word.toCharArray()) {
					counts.put(c, 0);
					adjList.put(c, new ArrayList<>());
				}
			}

			// Step 1: Find all edges.
			for (int i = 0; i < words.length - 1; i++) {
				String word1 = words[i];
				String word2 = words[i + 1];
				// Check that word2 is not a prefix of word1.
				if (word1.length() > word2.length() && word1.startsWith(word2)) {
					return "";
				}
				// Find the first non match and insert the corresponding relation.
				for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
					if (word1.charAt(j) != word2.charAt(j)) {
						adjList.get(word1.charAt(j)).add(word2.charAt(j));
						counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
						break;
					}
				}
			}

			// Step 2: Breadth-first search.
			StringBuilder sb = new StringBuilder();
			Queue<Character> queue = new LinkedList<>();
			for (Character c : counts.keySet()) {
				if (counts.get(c).equals(0)) {
					queue.add(c);
				}
			}
			while (!queue.isEmpty()) {
				Character c = queue.remove();
				sb.append(c);
				for (Character next : adjList.get(c)) {
					counts.put(next, counts.get(next) - 1);
					if (counts.get(next).equals(0)) {
						queue.add(next);
					}
				}
			}

			if (sb.length() < counts.size()) {
				return "";
			}
			return sb.toString();
		}
	}
	
	
	/**
	 * approach : DFS
	 * source : leetcode official solution
	 * link https://leetcode.com/problems/alien-dictionary/solutions/562919/alien-dictionary/
	 * @author partha
	 * @TC: O(C) where C is the total length of all the words in the input.
	 * @SC: O(1) or O(U+min⁡(U^2,N))  where N=total number of strings in the input list. and U=Total number of letters in alphabet series alphabets 
	 */
	 private static class LeetcodeOfficialSolution2 {
		    
		    private Map<Character, List<Character>> reverseAdjList = new HashMap<>();
		    private Map<Character, Boolean> seen = new HashMap<>();
		    private StringBuilder output = new StringBuilder();
		    
		    public String alienOrder(String[] words) {
		        
		        // Step 0: Put all unique letters into reverseAdjList as keys.
		        for (String word : words) {
		            for (char c : word.toCharArray()) {
		                reverseAdjList.putIfAbsent(c, new ArrayList<>());
		            }
		        }
		        
		        // Step 1: Find all edges and add reverse edges to reverseAdjList.
		        for (int i = 0; i < words.length - 1; i++) {
		            String word1 = words[i];
		            String word2 = words[i + 1];
		            // Check that word2 is not a prefix of word1.
		            if (word1.length() > word2.length() && word1.startsWith(word2)) {
		                return "";
		            }
		            // Find the first non match and insert the corresponding relation.
		            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
		                if (word1.charAt(j) != word2.charAt(j)) {
		                    reverseAdjList.get(word2.charAt(j)).add(word1.charAt(j));
		                    break;
		                }
		            }
		        }
		        
		        // Step 2: DFS to build up the output list.
		        for (Character c : reverseAdjList.keySet()) {
		            boolean result = dfs(c);
		            if (!result) return "";
		        }
		        
		        return output.toString();
		    }
		    
		    // Return true iff no cycles detected.
		    private boolean dfs(Character c) {
		        if (seen.containsKey(c)) {
		            return seen.get(c); // If this node was grey (false), a cycle was detected.
		        }
		        seen.put(c, false);
		        for (Character next : reverseAdjList.get(c)) {
		            boolean result = dfs(next);
		            if (!result) return false;
		        }
		        seen.put(c, true);
		        output.append(c);
		        return true;
		    }    
		}

}
