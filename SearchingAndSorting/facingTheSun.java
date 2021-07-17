/*
Given an array representing heights of buildings. The array has buildings from
left to right as shown in below diagram, count number of buildings facing the
sunset. It is assumed that heights of all buildings are distinct.
*/

class facingTheSun {
	public static int longest(int arr[],int n){
        int cnt = 1;
        int lmax = arr[0];
        for(int i = 1; i < n; i++){
        	if(arr[i] > lmax){
        		cnt++;
        		lmax = Math.max(lmax, arr[i]);
        	}
        }
        return cnt;
    }
	public static void main(String[] args) {
		int[] arr = {4, 7, 6, 5, 5, 7, 1, 8, 6};

		System.out.println(longest(arr, arr.length));
	}
}