package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/**
 * https://leetcode.com/problems/word-ladder
 * @author partha
 *
 */
public class WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	/**
	 * approach: breadth first search
	 * @source: leetcode official solution
	 * https://leetcode.com/problems/word-ladder/solutions/239223/word-ladder/
	 * timeComplexity: O(M^2  * N), where M is the length of each word and N is the total number of words in the input word list.
	 * spaceComplexity: O(M^2  * N), where M is the length of each word and N is the total number of words in the input word list.
	 * @author partha
	 *
	 */
	private static class Solution1 {
		public int ladderLength(String beginWord, String endWord, List<String> wordList) {

			// Since all words are of same length.
			int L = beginWord.length();

			// Dictionary to hold combination of words that can be formed,
			// from any given word. By changing one letter at a time.
			Map<String, List<String>> allComboDict = new HashMap<>();

			wordList.forEach( word -> {
				for (int i = 0; i < L; i++) {
					// Key is the generic word
					// Value is a list of words which have the same intermediate generic word.
					String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
					List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
					transformations.add(word);
					allComboDict.put(newWord, transformations);
				}
			});

			// Queue for BFS
			Queue<Map.Entry<String, Integer>> Q = new LinkedList<>();
			Q.add(Map.entry(beginWord, 1));

			// Visited to make sure we don't repeat processing same word.
			Map<String, Boolean> visited = new HashMap<>();
			visited.put(beginWord, true);

			while (!Q.isEmpty()) {
				Map.Entry<String, Integer> node = Q.remove();
				String word = node.getKey();
				int level = node.getValue();
				for (int i = 0; i < L; i++) {

					// Intermediate words for current word
					String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

					// Next states are all the words which share the same intermediate state.
					for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
						// If at any point if we find what we are looking for
						// i.e. the end word - we can return with the answer.
						if (adjacentWord.equals(endWord)) {
							return level + 1;
						}
						// Otherwise, add it to the BFS Queue. Also mark it visited
						if (!visited.containsKey(adjacentWord)) {
							visited.put(adjacentWord, true);
							Q.add(Map.entry(adjacentWord, level + 1));
						}
					}
				}
			}

			return 0;
		}
	}




	/**
	 * approach: Bidirectional Breadth First Search
	 * @source: leetcode official solution
	 * https://leetcode.com/problems/word-ladder/solutions/239223/word-ladder/
	 * timeComplexity: O(M^2  * N), where M is the length of each word and N is the total number of words in the input word list.
	 * spaceComplexity: O(M^2  * N), where M is the length of each word and N is the total number of words in the input word list.
	 * @author partha
	 *
	 */
	private static class Solution2 {

		private int L;
		private Map<String, List<String>> allComboDict;

		Solution2() {
			this.L = 0;

			// Dictionary to hold combination of words that can be formed,
			// from any given word. By changing one letter at a time.
			this.allComboDict = new HashMap<>();
		}

		private int visitWordNode(
				Queue<Map.Entry<String, Integer>> Q,
				Map<String, Integer> visited,
				Map<String, Integer> othersVisited) {

			for (int j = Q.size(); j > 0; j--) {

				Map.Entry<String, Integer> node = Q.remove();
				String word = node.getKey();
				int level = node.getValue();

				for (int i = 0; i < this.L; i++) {

					// Intermediate words for current word
					String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

					// Next states are all the words which share the same intermediate state.
					for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
						// If at any point if we find what we are looking for
						// i.e. the end word - we can return with the answer.
						if (othersVisited.containsKey(adjacentWord)) {
							return level + othersVisited.get(adjacentWord);
						}

						if (!visited.containsKey(adjacentWord)) {

							// Save the level as the value of the dictionary, to save number of hops.
							visited.put(adjacentWord, level + 1);
							Q.add(Map.entry(adjacentWord, level + 1));
						}
					}
				}
			}
			return -1;
		}

		public int ladderLength(String beginWord, String endWord, List<String> wordList) {

			if (!wordList.contains(endWord)) {
				return 0;
			}

			// Since all words are of same length.
			this.L = beginWord.length();

			wordList.forEach( word -> {
				for (int i = 0; i < L; i++) {
					// Key is the generic word
					// Value is a list of words which have the same intermediate generic word.
					String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
					List<String> transformations =
							this.allComboDict.getOrDefault(newWord, new ArrayList<>());
					transformations.add(word);
					this.allComboDict.put(newWord, transformations);
				}
			});

			// Queues for birdirectional BFS
			// BFS starting from beginWord
			Queue<Map.Entry<String, Integer>> Q_begin = new LinkedList<>();
			// BFS starting from endWord
			Queue<Map.Entry<String, Integer>> Q_end = new LinkedList<>();
			Q_begin.add(Map.entry(beginWord, 1));
			Q_end.add(Map.entry(endWord, 1));

			// Visited to make sure we don't repeat processing same word.
			Map<String, Integer> visitedBegin = new HashMap<>();
			Map<String, Integer> visitedEnd = new HashMap<>();
			visitedBegin.put(beginWord, 1);
			visitedEnd.put(endWord, 1);
			int ans = -1;

			while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

				// Progress forward one step from the shorter queue
				if (Q_begin.size() <= Q_end.size()) {
					ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
				} else {
					ans = visitWordNode(Q_end, visitedEnd, visitedBegin);    
				}

				if (ans > -1) {
					return ans;
				}
			}

			return 0;
		}
	}

}
