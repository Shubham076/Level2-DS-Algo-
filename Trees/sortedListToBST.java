//leetcode 109
class sortedListToBST {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	static ListNode temp;
	public TreeNode sortedListToBST(ListNode head) {
		temp = head;
		ListNode i = head;
		int cnt = 0;
		while (i != null) {
			cnt++;
			i = i.next;
		}

		return construct(cnt);
	}
	/*
		with size first we are defining the structure of the tree
		n = 7 
									7
								/     \
                              3        3
                            /  \     /  \
                          1    1    1    1
		                /  \  /  \ / \   / \
		               0  0 0   0 0  0 0   0
	in this way we are defining the structure of tree no of el on left = n / 2 and on right => n - n/2 - 1
	why minus 1 coz i element needed for root

	now when we backtrack we first reach the inorder of 1 where we place the first el of linkedlist and make the right call
	*/
	public TreeNode construct(int n) {
		if (n == 0) {
			return null;
		}
		TreeNode left = construct(n / 2);

		//inorder
		TreeNode root = new TreeNode(temp.val);
		temp = temp.next;
		
		root.left = left;
		root.right = construct(n - n / 2 - 1);
		return root;
	}
}