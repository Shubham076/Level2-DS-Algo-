/*   leetcode 1379
Given two binary trees original and cloned and given a reference to a node target in the original tree.
The cloned tree is a copy of the original tree.
Return a reference to the same node in the cloned tree.
Note that you are not allowed to change any of the two trees or the target node
 and the answer must be a reference to a node in the cloned tree.
*/
public class corresspondingNodeInCloneOfThatTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(target == null || original == null) return null;
        if(original == target) return cloned;
        
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left != null) return left;        
        
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if(right != null) return right;
        
        return null;
    }
}
