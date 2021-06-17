//leetcode 109
import java.util.*;
class sortedDLLToBSt {
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	static class TreeNode {
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
     	while(i != null){
     		cnt++;
     		i = i.next;
     	}

     	return construct(cnt);   
    }
//O(N)
    public static TreeNode construct(int n){
    	if(n == 0){
    		return null;
    	}
    	TreeNode left = construct(n / 2); 
    	TreeNode root = new TreeNode(temp.val);
    	temp = temp.next;
    	root.left = left;
    	root.right = construct(n - n / 2 - 1);
    	return root;
    }	
}