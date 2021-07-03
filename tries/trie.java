//prefix tree using hashmap
import java.util.*;
class Trie {
	class Node {
		char c;
		HashMap<Character, Node> map = new HashMap<>();
		boolean isTerminal;

		Node(char d) {
			this.c = d;
			isTerminal = false;
		}
	}

	Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node('\0');
	}

	public void insert(String s) {
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

	public boolean search(String s) {
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
		System.out.println(t.search("man"));
	}
}