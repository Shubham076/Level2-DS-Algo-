/*leetcode 107
print bootom up level order traversal
*/
import java.util.*;
class levelOrderTraversal2 {
	static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TreeNode constructTree(Integer[] arr) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(new TreeNode(arr[0], null, null));
        TreeNode root = null;
        int i = 1;
        while (q.size() > 0 && i < arr.length) {
            TreeNode rp = q.remove();
            if (root == null) {
                root = rp;
            }

            // adding the left child
            if (arr[i] != null) {
                rp.left = new TreeNode(arr[i], null, null);
                q.add(rp.left);
            }
            i++;

            if (i >= arr.length)
                break;

            // adding the right child
            if (arr[i] != null) {
                rp.right = new TreeNode(arr[i], null, null);
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }

    // when return type is list<list<integer>
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < s; i++){
                TreeNode r = q.remove();
                temp.add(r.val);
                
                if(r.left != null){
                    q.add(r.left);
                }       
                if(r.right != null){
                    q.add(r.right);
                }
            }
            
            list.add(temp);
        }
        Collections.reverse(list);
        return list;
    }

    // when return type is list<integer> first add right child then left then
    // reverse the overall list
    public static List<Integer> levelOrderBottom2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0){
            int s = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < s; i++){
                TreeNode r = q.remove();
                list.add(r.val);
                
                if(r.right != null){
                    q.add(r.right);
                }
                if(r.left != null){
                    q.add(r.left);
                }       
            }
        }
        Collections.reverse(list);
        return list;
    }
	public static void main(String[] args) {
		Integer[] arr = {3, 9, 20, null, null, 15, 7};
		TreeNode root = constructTree(arr);
		List<List<Integer>> ans1 = levelOrderBottom1(root);
		List<Integer> ans2 = levelOrderBottom2(root);
		System.out.println(ans1);
		System.out.println(ans2);
	}
}