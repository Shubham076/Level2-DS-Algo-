//leetcode 11
class containerWithMostWater {
	public static int maxArea(int[] height) {
		int area = 0;
		int left = 0;
		int right = height.length - 1;
		while(left < right){
			area = Math.max(area , Math.min(height[left], height[right]) * (right - left));
			if(height[left] < height[right]){
				left++;
			}
			else{
				right--;
			}
		}
		return area;
	}
	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1, 4};
		System.out.println(maxArea(arr));
	}
}