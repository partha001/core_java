package com.partha.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 * @author partha
 *
 */
public class ImplementTriePrefixTreeMyImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * https://www.youtube.com/watch?v=oobqoCJlHA0
	 * @author partha
	 *	using a hashmap to use the child nodes instead of an array. 
	 *  in that way we are not restricted to alphabets only
	 */
	private static class Trie {

	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }



	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode node = root;
	        for (char c:word.toCharArray()) {
	            if (!node.children.containsKey(c)) {
	                node.children.put(c, new TrieNode());
	            }
	            node = node.children.get(c);
	        }
	        node.isEnd = true;
	    }
	    

	    public boolean startsWith(String word) {
	        TrieNode node = root;
	        for (char c: word.toCharArray()) {
	           if (node.children.containsKey(c)) {
	               node = node.children.get(c);
	           } else {
	               return false;
	           }
	        }
	        return true; 
	    }



	    //same as startsWith only difference as here we check if the last node after iteration
	    //is true or not.if not true we return false which is stored in isEnd
	    public boolean search(String word) {
	       TrieNode node = root;
	        for (char c: word.toCharArray()) {
	           if (node.children.containsKey(c)) {
	               node = node.children.get(c);
	           } else {
	               return false;
	           }
	        }
	        return node.isEnd;
	    }
	    
	}
	
	
	private static class TrieNode {

		
		Map<Character,TrieNode> children;
	    boolean isEnd;

	    public TrieNode() {
	       children = new HashMap<>();
	    }

	}

}
