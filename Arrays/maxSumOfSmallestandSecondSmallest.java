class maxSumOfSmallestandSecondSmallest{
	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 5, 6};
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length - 1; i++){
			max = Math.max(max , (arr[i] + arr[i + 1]));
		}
		System.out.println(max);
	}
}