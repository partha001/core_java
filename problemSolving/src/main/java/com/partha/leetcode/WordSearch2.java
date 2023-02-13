package com.partha.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/
 * @author partha
 *
 */
public class WordSearch2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = new String[] {"eat","rain"};
		System.out.println(new WordSearch2.Solution1().findWords(board, words));
	}



	/**
	 * https://www.youtube.com/watch?v=asbcE9mZz_U
	 * @author partha
	 *
	 */
	private static class Solution1 {

		int rows =0;
		int cols =0;

		public List<String> findWords(char[][] board, String[] words) {
			Trie trie =new Trie();
			for(String word: words)
				addWord(trie, word);

			rows = board.length;
			cols = board[0].length;

			Set<String> found = new HashSet(); // as we dont wana the word twice to our list
			int[][] vis = new int[rows][cols]; //to keep track of visits

			for(int i=0;i<rows;i++){
				for(int j=0;j<cols;j++){
					dfs(i, j, board,  found, vis, trie , "");
				}
			}

			return new ArrayList<String>(found);

		}


		public void dfs(int row,int col,char[][] board, Set<String> found ,int[][] vis , Trie node,String currentString){
			if(row==rows || col==cols || row<0 || col<0 || 
					vis[row][col]==1 ||
					!node.map.containsKey(board[row][col])){
				return;
			}

			vis[row][col]=1;
			node = node.map.get(board[row][col]);
			currentString += node.val;
			if(node.end){
				found.add(currentString);
			}


			dfs(row , col-1,   board, found , vis, node, currentString);
			dfs(row , col+1,   board, found , vis, node, currentString);
			dfs(row -1, col,   board, found , vis, node, currentString);
			dfs(row +1, col,   board, found , vis, node, currentString);

			vis[row][col]=0;
		}


		private void addWord(Trie node, String word){
			for(int i=0;i<word.length();i++){
				if(!node.map.containsKey(word.charAt(i))){
					Trie child = new Trie();
					child.val = word.charAt(i);
					node.map.put(child.val, child);
				}
				node = node.map.get(word.charAt(i));
			}
			node.end = true;
		}


	}



	private static class Trie {
		Character val;
		Map<Character,Trie> map = new HashMap();
		boolean end;

	}





}
