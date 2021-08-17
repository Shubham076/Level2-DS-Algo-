//https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
class minIntegerNotRepresentedBySumOfSubset{
	public static void main(String[] args) {
		int[] arr = {1, 3, 6, 10, 11, 15};
		int n = 1;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > n){
				System.out.println(n);
				return;
			}
			n += arr[i];
		}
		System.out.println(n);
	}
}