class firstAndLastPositionInSortedArray {
	public static void solve(int[] arr, int t) {
		int lo = 0, hi = arr.length - 1;
		int first = -1;
		int last = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == t) {
				first = mid;
				hi = mid - 1;
			} 
			else if (arr[mid] > t) {
				hi = mid - 1;
			} 
			else {
				lo = mid + 1;
			}
		}
		lo = 0;
		hi = arr.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] == t) {
				last = mid;
				lo = mid + 1;
			}
			 
			else if (arr[mid] > t) {
				hi = mid - 1;
			}
			 
			else {
				lo = mid + 1;
			}
		}

		System.out.println(first + " " + last);
	}
	public static void main(String[] args) {
		int[] arr = {3, 3, 5, 5 , 5 , 6, 7};
		int target = 5;
		solve(arr, target);
	}
}	