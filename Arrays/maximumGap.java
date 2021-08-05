/*
leetcode 164
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.
You must write an algorithm that runs in linear time and uses linear extra space.

Bruteforce sort the array ans find the max diff;
doubt
*/
class maximumGap{
	public static int maximumGap(int[] nums) {
        if(nums.length == 1) return 0;

    }
	public static void main(String[] args) {
		int[] arr = {3, 6, 9, 1};
		 System.out.println(maximumGap(arr));
	}
}