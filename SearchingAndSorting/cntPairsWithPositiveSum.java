//https://www.geeksforgeeks.org/count-number-of-pairs-with-positive-sum-in-an-array/
import java.util.*;
class cntPairsWithPositiveSum{
	public static void main(String[] args) {
		int[] arr = {-7, -1, 3, 2};
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		int cnt = 0; 
		while(i < j){
			int sum = arr[i] + arr[j];
			if(sum <= 0){
				i++;
			}
			else{
				cnt += (j - i);
				j--;
			}
		}
		System.out.println(cnt);
	}
}