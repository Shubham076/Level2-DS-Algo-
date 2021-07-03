//A non-empty zero-indexed array A consisting of N integers is given. You can perform 1 or less swap operation in array A.
// The goal is to check whether array A can be non-decreasing order after 1 or less swap.

// or

//Check if array can be sorted with one swap
class checkArraySortedAfterOneswap{

	public static void swap(int i, int j, int[] arr){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args){
		int[] arr = {1, 5, 3, 4, 2};
		int idx1 = 0;
		int idx2 = 0;
		int cnt = 0;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i - 1]){
				cnt++;

				if(idx1 == 0){
					idx1 = i;
				}
				else{
					idx2 = i;
				}
			}
		}

		if(cnt > 2){
			System.out.println(false);
			return;
		}
		else if(cnt == 0){
			System.out.println(true); //already sorted
			return;
		}
		else if(cnt == 2){
			// Cases like {3, 2, 1}
			swap(idx1 - 1 , idx2, arr);
		}
		else if(cnt == 1){
			// Cases like {1, 2, 4, 3, 5}
			swap(idx1, idx1 - 1, arr);
		}

		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i - 1]){
				System.out.println(false);
					return;
			}
		}
		System.out.println(true);
	}
}
