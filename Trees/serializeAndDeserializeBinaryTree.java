//leetcode 297
import java.util.*;
class serializeAndDeserializeBinaryTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder s = new StringBuilder();
        while(q.size() > 0){
            TreeNode rm = q.remove();
            if(rm == null){
                s.append("null,");
            }
            else{
                s.append(rm.val + ",");
                q.add(rm.left);
                q.add(rm.right);
            }           
        }
        return s.toString();   
    }

    public static TreeNode deserialize(String str){
    	if (str == null || str.length() == 0) 
            return null;
    	String[] arr = str.split(",");
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(new TreeNode(Integer.parseInt(arr[0])));
        TreeNode root = null;
        int i = 1;
        while(q.size() > 0 && i < arr.length){
            TreeNode rp = q.remove();
            if(root == null){
                root = rp;
            }

            //adding the left child
            if(!arr[i].equals("null")){
                rp.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(rp.left);
            }
            i++;

            if(i >= arr.length) break;
            
            //adding the right child
            if(!arr[i].equals("null")){
                rp.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }
}