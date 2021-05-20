//leetcode 437
import java.util.*; 
public class pathSum3 {
    public class TreeNode {
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

	//O(N^2)
	public int countPaths(TreeNode root, int targetSum){
		if(root == null) return 0;
		int lc = countPaths(root.left, targetSum - root.val);
		int rc = countPaths(root.right, targetSum - root.val);
		return (root.val == targetSum ? 1 : 0) + lc + rc; 
	}

	//at each level we have 2 choice we have to to include root or not
	public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
		return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + countPaths(root, targetSum);
    }
	
	
	//method 2 O(N)
	HashMap<Integer, Integer> map;
	int ans;
	//psum = prefix sum
	public void countPaths2(TreeNode root, int targetSum,  int psum){
		if(root == null) return;
		psum += root.val;
		if(map.containsKey(targetSum - psum)){
			ans += map.get(targetSum - psum);
		}
		map.put(psum, map.getOrDefault(psum, 0) + 1);

		countPaths2(root.left, targetSum, psum);
		countPaths2(root.right, targetSum, psum);

		//removing current contibution as we backtrack
		map.put(psum, map.get(psum) - 1);
        if (map.get(psum) == 0)
            map.remove(psum);

	}
	public int pathSum2(TreeNode root, int targetSum){
		if(root == null) return 0;
		map = new HashMap<>(); //prefix sum vs cnt;
		ans = 0;  
		map.put(0 , 1);
		countPaths2(root, targetSum, 0);
		return ans; 
	}
}
