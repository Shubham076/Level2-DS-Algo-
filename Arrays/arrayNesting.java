//leetode 565
class arrayNesting {

	//time and space complexity will be O(N)
	public static int arrayNesting(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			int count = 0;
			while(visited[j] == false){
				visited[j] = true;
				j = nums[j];
				count++;
			}
			res = Math.max(res, count);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {5, 4, 0, 3, 1, 6, 2};
		System.out.println(arrayNesting(arr));
	}
}