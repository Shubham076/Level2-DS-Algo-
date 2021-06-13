//suffix tree 
import java.util.*;
class Trie {
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
	Trie() {
		root = new Node('\0');
	}
	// O(key_length)
	void insert(String s) {
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
		String[] s = {"apple", "ape", "mango", "man"};
		Trie t = new Trie();
		for (String str : s) {
			t.insert(str);
		}

		System.out.println(t.search("india"));
	}
}