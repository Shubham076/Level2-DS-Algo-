// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
import java.util.*;
// Time complexity nlogn
class jobSequencing {
	static int[] par;
	//logn 
	public static int find(int n){
		if(par[n] == n){
			return n;
		}
		int temp = find(par[n]);
		par[n] = temp;
		return temp;
	}

	public static void union(int x,int y){
		int lx = find(x);
		int ly = find(y);
		if(lx != ly){
			par[ly] = lx;
		}
	}
	int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> b.profit - a.profit);  //nlogn
		// 100 is the max deadline
		par = new int[101]; //1 based indexing
		for(int i = 0; i <= 100; i++){
			par[i] = i;
		}
		int ans = 0;
		int cnt = 0;
		//leader is always pointing towards empty slot  nlogn
		for(Job j: arr){
			int freeSlot = find(j.deadline);
			if(freeSlot > 0){
				ans += j.profit;
				cnt++;
				int x = find(freeSlot - 1);
				union(x, freeSlot);
			}
		}
		return new int[] {cnt, ans};
	}
}