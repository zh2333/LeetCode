package com.leetcode.p208;

/**
 * 瀹炵幇涓�涓� Trie (鍓嶇紑鏍�)锛屽寘鍚� insert, search, 鍜� startsWith 杩欎笁涓搷浣溿��
	绀轰緥:
	Trie trie = new Trie();
	trie.insert("apple");
	trie.search("apple");   // 杩斿洖 true
	trie.search("app");     // 杩斿洖 false
	trie.startsWith("app"); // 杩斿洖 true
	trie.insert("app");   
	trie.search("app");     // 杩斿洖 true
 * @author 寮犳亽
 *
 */
class Trie {

    /** Initialize your data structure here. */
    public Trie() {

    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */