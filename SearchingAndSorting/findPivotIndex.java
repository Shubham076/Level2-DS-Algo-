//leetcode 724
class findPivotIndex {
	public static int pivotIndex(int[] nums) {
		int ts = 0;
		for(int i = 0; i < nums.length; i++){
			ts += nums[i];
		}

		int ls = 0; //left sum
		int rs = ts; //right sum
		for(int i = 0; i < nums.length; i++){
			rs -= nums[i];
			if(ls == rs) return i;

			ls += nums[i];
		}

		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {1, 7, 3, 6, 5, 6};
		System.out.println(pivotIndex(arr));
	}
}