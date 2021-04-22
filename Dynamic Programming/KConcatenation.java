class KConcatenation {
	public static int kadanes(int[] arr) {
		int curMax = arr[0];
		int omax = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (curMax >= 0) {
				curMax += arr[i];
			} else curMax = arr[i];

			if (curMax > omax) {
				omax = curMax;
			}

		}
		return omax;
	}

	public static int kConcatenation(int[] arr, int k) {
		int n = arr.length;

		if (k == 1) {
			return kadanes(arr);
		} else {
			int[] marr = new int[2 * n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				marr[i] = arr[i];
				sum += arr[i];
			}

			for (int i = 0; i < n; i++) {
				marr[i + n] = arr[i];
			}

			if (sum < 0) {
				return kadanes(marr);
			} else {
				return kadanes(marr) + (k - 2) * sum;
			}
		}
	}
	//array duplicated k times find the maximum sum subarray
	public static void main(String[] max) {
		int[] arr = {-1, -2};
		int k = 3;
		System.out.println(kConcatenation(arr, k));
	}

}
