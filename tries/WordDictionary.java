//leetcode 211
import java.util.*;
class WordDictionary {
	class Node {
		Node[] childs;
		boolean isTerminal;

		Node() {
			isTerminal = false;
			childs = new Node[26];
		}
/*		          
				* car (i = 0)
               /  
              c  car (i = 1)
             /    
            a    car (i = 2)
		  /      
		 r car  (i = 3 == str.length())
*/
		boolean find(String word, int i){
			if(i == word.length()){
				return isTerminal;
			}
			char ch = word.charAt(i);
			if(ch == '.'){
				for(Node c : childs){
					if(c != null && c.find(word, i + 1)){
						return true;
					}
				}
				return false;
			}
			else{
				if(childs[ch - 'a'] == null){
					return false;
				}
				else{
					return childs[ch - 'a'].find(word, i + 1);
				}
			}
		}
	}

	Node root;
	WordDictionary() {
		root = new Node();
	}
	// O(key_length)
	void addWord(String s) {
		Node cur = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(cur.childs[c - 'a'] == null){
				cur.childs[c - 'a'] = new Node();
			}
			cur = cur.childs[c - 'a'];
		}
		cur.isTerminal = true;
	}
	// O(key_length)
	boolean search(String s) {
		return root.find(s, 0);
	}
}