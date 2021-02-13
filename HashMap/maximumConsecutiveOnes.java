import java.util.*;
class maximumConsecutiveOnes{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		int count = 0;
		int ans = 0;
		int j = -1;
		for(int i = 0; i < n; i++){
			if(arr[i] == 0){
				count++;
			}

			while(count > k){
				j++;
				if(arr[j] == 0){
					count--;
				}
			}

			int len = i - j;
			if(len > ans){
				ans = len;
			}

		}
		System.out.println(ans);
	}
}