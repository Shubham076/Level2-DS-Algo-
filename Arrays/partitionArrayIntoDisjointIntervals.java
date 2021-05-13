class partitionArrayIntoDisjointIntervals {
	public static int partitionDisjoint(int[] a) {
		int n = a.length;
		int[] max = new int[n];
		int[] min = new int[n];

		max[0] = a[0];
		min[n - 1] = a[n - 1];
		for(int i = 1; i < a.length; i++){
			max[i] = Math.max(a[i], max[i - 1]);
		}

		for(int i = n - 2; i >= 0; i--){
			min[i] = Math.min(a[i], min[i + 1]);
		}

		for(int i = 0; i < n - 1; i++){
			if(max[i] <= min[i + 1]) return i + 1;
		}
        return -1;
    }
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 0, 6, 12};
		System.out.println(partitionDisjoint(arr));
	}
}