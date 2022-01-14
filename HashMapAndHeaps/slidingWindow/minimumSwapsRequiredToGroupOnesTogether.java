//https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/
import java.util.*;
class minimumSwapsRequiredToGroupOnesTogether{
	public static void main(String[] args){
		int[] arr = {1, 0, 1, 0, 1};
		int[] pre = new int[arr.length];
		int cnt = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1){
				cnt++;
			}
		}

		if(cnt == 0){
			return;
		}
		pre[0] = arr[0] == 1 ? 1 : 0;
		for(int i = 1; i < arr.length; i++){
			pre[i] = pre[i - 1] + (arr[i] == 1 ? 1 : 0);
		}

		//find the subarray of length cnt having max number of zeros;
		int max = pre[cnt - 1];
		for(int i = cnt; i < arr.length; i++){
			max = Math.max(max, pre[i] - pre[i - cnt]);
		}
		System.out.println(cnt - max);
	}
}