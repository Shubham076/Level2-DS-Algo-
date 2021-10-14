//https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1
// For each element in arr1[] count elements less than or equal to it in array arr2[].
import java.util.*;
class countElementsInTwoArrays {

	public static int binarySearch(int val, int[] arr){
		int cnt = 0;
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(arr[mid] <= val){
				cnt += mid - lo + 1;
				lo = mid + 1;
			}
			else{
				hi = mid - 1;
			}
		}
		return cnt;
	}

	//nlogn + O(1) space
	public static ArrayList<Integer> countEleLessThanOrEqual1(int arr1[], int arr2[], int m, int n) {
		Arrays.sort(arr2);
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < m; i++){
			ans.add(binarySearch(arr1[i], arr2));
		}
		return ans;
	}

	//O(N) + O(2 * max arr2[i])  space = O(2 * max of arr1)
	public static ArrayList<Integer> countEleLessThanOrEqual2(int arr1[], int arr2[], int m, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		int[] freq = new int[1_00_000];
		int[] psum = new int[1_00_000];
		for(int i = 0; i < n; i++){
			freq[arr2[i]]++;
		}

		psum[0] = freq[0];
		for(int i = 1; i < psum.length; i++){
			psum[i] = psum[i - 1] + freq[i];
		}

		for(int v : arr1){
			ans.add(psum[v]);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr1 = {4, 8, 7, 5, 1};
		int[] arr2 = {4, 48, 3, 0, 1, 1, 5 };
		System.out.println(countEleLessThanOrEqual1(arr1, arr2, arr1.length, arr2.length));
		System.out.println(countEleLessThanOrEqual2(arr1, arr2, arr1.length, arr2.length));
	}
}