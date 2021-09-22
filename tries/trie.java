//prefix tree using hashmap
import java.util.*;
class Trie {
	class Node {
		HashMap<Character, Node> map = new HashMap<>();
		boolean isTerminal;
		String s;

		Node() {
			isTerminal = false;
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
	}

	public void insert(String s) {
		Node temp = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!temp.map.containsKey(c)) {
				Node n = new Node();
				temp.map.put(c, n);
			}
			temp = temp.map.get(c);
		}
		temp.isTerminal = true;
		temp.s = s;
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

	public void print(){
		printHelper(root);
	}

	private void printHelper(Node root){
		if(root == null) return;
		if(root.isTerminal){
			System.out.println(root.s);
		}

		for(char c: root.map.keySet()){
			printHelper(root.map.get(c));
		}
	}
	public static void main(String[] args) {
		String[] s = {"apple", "ape", "mango", "man"};
		Trie t = new Trie();
		for (String str : s) {
			t.insert(str);
		}
		System.out.println(t.search("man"));
		t.print();
	}
}