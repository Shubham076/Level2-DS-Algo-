//leetcode 283
class moveZeroes {
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void moveZeroes(int[] nums) {
        int j = 0;  //last non zero found
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] != 0){
        		swap(nums, j, i);
        		j++;
        	}
        }
    }
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 3, 12};
		moveZeroes(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}