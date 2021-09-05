/*   leetcode 421
we can the solution in o(N * N) by checking all the pairs and compete with max
but we can do better with tries;
what we do for each no try to find the number closest to its compliment in the trie
why because the max xor of no is equal to product of no and its compliment
O(32 * N) in the worst case O(N)
*/
class max_XOR_Of2NumbersInArray {
	static class Trie {
		class Node {
			Node left;
			Node right;
		}

		Node root;
		Trie(){
			root = new Node();
		}

		void insert(int num) {
			Node cur = root;
			int bits = 31; // (0 - 31) = 32 bits;
			while (bits >= 0) {

				//getting the ith bit in the number
				int mask = 1 << bits;
				int bit = (num & mask) > 0 ? 1 : 0;
				if (bit == 0) {
					if(cur.left == null){
						cur.left = new Node();
					}
					cur = cur.left;
				}
				else{
					if(cur.right == null){
						cur.right = new Node();
					}
					cur = cur.right;
				}
				bits--;
			}
		}

		int search(int num){
			int ans = 0;
			Node cur = root;
			int bits = 31; // (0 - 31) = 32 bits;
			while (bits >= 0) {

				//getting the ith bit in the number
				int mask = 1 << bits;
				int bit = (num & mask) > 0 ? 1 : 0;
				if (bit == 0) {
					//means requirement is of zero
					
					//if zero is present 
					if(cur.left != null){
						cur = cur.left;
					}
					else{
						//means zero is not present so set the ith bit to 1;
						ans |= mask;
						cur = cur.right;
					}
				}
				else{

					//means requirement is of one
					//if one is present
					if(cur.right != null){
						ans |= mask;
						cur = cur.right;
					}
					else{
						//means 1 is not present
						cur = cur.left;
					}
				}
				bits--;
			}
			return ans;
		}
	}

	public static int findMaximumXOR(int[] nums) {
		Trie t = new Trie();
		for(int i: nums){
			t.insert(i);
		}
		int max = Integer.MIN_VALUE;
		for(int val: nums){
			int find = (~val);
			int res = t.search(find);
			max = Math.max(max, (val ^ res));
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {2, 4};
		System.out.println(findMaximumXOR(arr));
	}
}