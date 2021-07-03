// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
/*
This can be easily done by visualizing the problem as a graph. We will have n
nodes and an edge directed from node i to node j if the element at i’th index
must be present at j’th index in the sorted array.

*/
import java.util.*;
class minSwapsRequiredToSortArray{
	static class Pair{
		int n;
		int i;
		Pair(int n, int i){
			this.n = n;
			this.i = i;
		}
		public String toString(){
			return this.n + "-" + this.i;
		}
	}

	//O(nlogn + n);
	public static int minSwaps(int nums[]){
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++){
        	arr[i] = new Pair(nums[i], i);
        }
        int[] visited = new int[n]; 
        int ans = 0;
        Arrays.sort(arr, (a, b)-> a.n - b.n);
        for(int i = 0; i < n; i++){

        	//if element is already or the position of element after soring is equal to position before sortng
        	if(arr[i].i == i){
        		visited[i] = 1;
        	}
        	if(visited[i] == 1){  
        		continue;
        	}
        	int cycle_size = 0;
        	int j = i;
        	while(visited[j] == 0){
        		visited[j] = 1;
        		j = arr[j].i;
        		cycle_size++;
        	}
        	ans += cycle_size - 1;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] arr = {7, 16, 14, 17, 6, 9, 5, 3, 18};
		System.out.println(minSwaps(arr));
	}
}