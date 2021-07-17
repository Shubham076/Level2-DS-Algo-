class elementAppearOnceInSortedArray {
	static int findOnce(int arr[], int n){
		//if array is even size that is not possible as it is given in ques all elements apeear twice except once
		//if size is even means 2 elements appear have a req of one
		if(n % 2 == 0){
			return -1;
		}
		if(n == 1){
			return arr[0];
		}
		if(arr[0] != arr[1]){
			return arr[0];
		}
		if(arr[n - 1] != arr[n - 2]){
			return arr[n - 1];
		}

		int lo = 0;
		int hi = n - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;

			if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
				return arr[mid];
			}
			else if(arr[mid] == arr[mid - 1]){
				int lc = mid - lo + 1;
				if(lc % 2 == 0){
					lo = mid + 1;
				}
				else{
					hi = mid - 2;
				}
			}
			else if(arr[mid] == arr[mid + 1]){
				int rc = hi - mid + 1;
				if(rc % 2 == 0){
					hi = mid - 1;
				}
				else{
					lo = mid + 2;
				}
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
		System.out.println(findOnce(arr, arr.length));
	}
}