class rainwaterTrapping {
	//method 1
	public int maxArea1(int[] height) {
		int[] left = new int[height.length];    // prefix max
		int[] right = new int[height.length];   //suffix max;

		if (height.length == 0) return 0;

		left[0] = height[0];
		for (int i = 1; i < left.length; i++) {
			left[i] = Math.max(height[i], left[i - 1]);
		}

		right[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}

		int water = 0;
		for (int i = 0; i < height.length; i++) {
			water += Math.min(left[i], right[i]) - height[i];
		}
		return water;
	}

	public int maxArea2(int[] height){
		int i = 0;
		int j = height.length - 1;
		int pmax = 0;
		int smax = 0;
		int ans = 0;
		while(i < j){
			pmax = Math.max(pmax, height[i]);
			smax = Math.max(smax, height[j]);

			if(pmax <= smax){
				ans += pmax - height[i];
				i++;
			}
			else{
				ans += smax - height[j];
				j++;
			}
		}
		return ans;
	}
}