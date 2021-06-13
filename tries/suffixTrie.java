import java.util.*;
class suffixTrie{
	static class Node {
		char c;
		HashMap<Character, Node> map = new HashMap<>();
		boolean isTerminal;

		Node(char d) {
			this.c = d;
			isTerminal = false;
		}
	}

	Node root;
	suffixTrie() {
		root = new Node('\0');
	}
	// O(key_length)
	void insertHelper(String s) {
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!temp.map.containsKey(c)) {
				Node n = new Node(c);
				temp.map.put(c, n);
			}
			temp = temp.map.get(c);
		}
		temp.isTerminal = true;
	}

	void insert(String s){
		for(int i = 0; i < s.length(); i++){
			insertHelper(s.substring(i));
		}
	}
	// O(key_length)
	boolean search(String s) {
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!temp.map.containsKey(c)) {
				return false;
			}
			temp = temp.map.get(c);
		}
		return temp.isTerminal;
	}
	public static void main(String[] args) {
		String[] s = {"apple"};
		String[] words = {"pple", "ple", "le", "el"};
		suffixTrie t = new suffixTrie();
		for (String str : s) {
			t.insert(str);
		}
		for(String str : words)
			System.out.print(t.search(str) + " ");
	}
}