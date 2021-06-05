/*
gfg
Inversion Count for an array indicates – how far (or close) the array is from being sorted.
If the array is already sorted, then the inversion count is 0,
but if the array is sorted in the reverse order, the inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j 
*/
class inversionCount{
	static long cnt;
	public static long[] merge2SortedArrays(long[] left, long[] right){
		int i = 0, j = 0, k = 0;
		long[] ans = new long[left.length + right.length];
		while(i < left.length && j < right.length){
			if(left[i] <= right[j]){
				ans[k] = left[i];
				i++;
				k++;
			}
			else{
				cnt += left.length - i;
				ans[k] = right[j];
				j++;
				k++;
			}
		}

		while(i < left.length){
			ans[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length){
			ans[k] = right[j];
			j++;
			k++;
		}
		return ans;
	}
	public static long[] mergeSort(long[] arr, int lo, int hi){
		if(lo == hi){
			long[] br = new long[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;
		long[] left = mergeSort(arr, lo, mid);
		long[] right = mergeSort(arr, mid + 1, hi);
		long[] merged = merge2SortedArrays(left, right);
		return merged;
	}
	static long inversion_count(long arr[]){
		int n = arr.length;
		cnt = 0;
		mergeSort(arr, 0 , n - 1);
		return cnt;
    }
	public static void main(String[] args){
		long[] arr = {2, 4, 1, 3, 4};
		inversion_count(arr);
		System.out.println(cnt);
	}
}