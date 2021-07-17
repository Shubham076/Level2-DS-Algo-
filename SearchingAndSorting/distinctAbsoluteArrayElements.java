/*
https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1
Given a sorted array of integers, return the number of distinct absolute
values among the elements of the array. The input can contain duplicates
values. 
*/
class distinctAbsoluteArrayElements{
	static int distinctCount(int[] arr, int n) {
		int next = Integer.MAX_VALUE;
		int prev = Integer.MIN_VALUE;
		int i = 0;
		int j = n - 1;
		int cnt = 0;
		while(i <= j){
			if(Math.abs(arr[i]) == Math.abs(arr[j])){
				if(arr[i] != prev && arr[j] != next){
					cnt++;
				}
				prev = arr[i];
				next = arr[j];
				i++;
				j--;
			}
			else if(Math.abs(arr[i]) > Math.abs(arr[j])){
				if(arr[i] != prev){
					cnt++;
				}
				prev = arr[i];
				i++;
			}
			else{
				if(arr[j] != next){
					cnt++;
				}
				next = arr[j];
				j--;
			}
		}
		return cnt;
    }
	public static void main(String[] args) {
		int[] arr = {-3, -2, 0, 3, 4, 5};
		System.out.println(distinctCount(arr, arr.length));
	}
}