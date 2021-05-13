//leetcode 977
class squaresOfSortedArray{
	public static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while(i <= j){
            int v1 = nums[i] * nums[i];
            int v2 = nums[j] * nums[j];
            if(v1 > v2){
                ans[k] = v1;
                i++;
                k--;
            }
            else{
                ans[k] = v2;
                j--;
                k--;
            }    
        }
        return ans;
    }
	public static void main(String[] args){
		int[] arr = {-4, -1, 0, 3, 10};
		int[] ans = sortedSquares(arr);
		for(int i : ans){
			System.out.print(i + " ");
		}
	}
}