//leetcode 169
class majorityElements{

	//Boyer-moore algorithm(for pairing of the distinct elements)
	public static int majorityElement(int[] nums) {
		int val = nums[0];
		int count = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == val){
				count++;
			}
			else if(nums[i] != val && count == 0){
				val = nums[i];
				count = 1;
			}
			else{
				count--;
			}
		}

		return val;
	}
	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		System.out.println(majorityElement(arr));
	}
}      