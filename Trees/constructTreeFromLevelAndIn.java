import java.util.*;
class constructTreeFromLevelAndIn {
	static class Node {
		int data;
		Node left, right;

		Node(int val) {
			data = val;
			this.left = null;
			this.right = null;
		}
	}
	static HashMap<Integer, Integer> map;
	static Node buildTree(int in[], int level[]) {
		map = new HashMap<>();
		for (int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return constructTree(level, 0, in.length - 1);
	}

//	is =>  inorder start , ie => inorder end, l => level order
	public static Node constructTree(int[] l, int is, int ie) {
		if(l.length == 0){
			return null;
		}

		if(is == ie){
			return new Node(l[0]);
		}

		Node n = new Node(l[0]);
		int idx = map.get(l[0]);

		int[] l_left = new int[idx - is];
		int[] l_right = new int[ie - idx];
		int li = 0, ri = 0;

		for (int i = 0; i < l.length; i++) {
			if (map.get(l[i]) < idx) {
				l_left[li++] = l[i];
			}
			else if(map.get(l[i]) > idx) {
				l_right[ri++] = l[i];
			}
		}
		n.left = constructTree(l_left, is, idx - 1);
		n.right = constructTree(l_right, idx + 1, ie);
		return n;
	}

	public static void main(String[] args) {
		int[] lo = {0, 1, 2};
		int[] in = {1, 0, 2};
		buildTree(in, lo);
	}
}