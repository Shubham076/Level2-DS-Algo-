class maximumProductSubarray {
	public static int maxProduct(int[] nums) {
		int p = 1;  //prefix product
		int s = 1; //suffix product
		int n = nums.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			// if we get a zero we will start a new subarray or we can say we are dividing array across 0
			if(p == 0){
				p = 1;
			}
			if(s == 0){
				s = 1;
			}
			p *= nums[i];
			s *= nums[n - 1 - i];
			max = Math.max(max, Math.max(p, s));
		}
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {-2, 0, -1};
		System.out.println(maxProduct(arr));
	}
}