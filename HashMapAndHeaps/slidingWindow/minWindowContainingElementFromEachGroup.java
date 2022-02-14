/*
You are given k number of groups having unequal ranges :-
g1 - 0 - 10
g2 - 11 -15
g3 - 16-22
g4 - 23-34

and a sequence of numbers. You have to find the length of minimum window containing element from 
every group. I had to do this without using map.
for eg. 9, 5, 3, 12, 17, 25, 27
Ans - 4


*/
class minWindowContainingElementFromEachGroup{
	static int search(int[][] arr, int el){
	    int lo = 0;
	    int hi = arr.length - 1;
	    int idx = -1;
	    while(lo <= hi){
	        int mid = lo  + (hi - lo) / 2;
	        if(arr[mid][0] <= el && arr[mid][1] >= el ){
	            idx = mid;
	            break;
	        }
	        else if(arr[mid][0] > el){
	            hi = mid - 1;
	        }
	        else{
	            lo = mid + 1;
	        }
	    }
	    return idx;
	}
	static boolean markGroup(int[][] arr, int el, int[] used, int[] cnt){
	    int idx = search(arr, el);
	    if(idx == -1) return false;
	    cnt[idx]++;
	    if(used[idx] == 1){
	        return false;
	    }
	    else{
	        used[idx] = 1;
	        return true;
	    }
	}

	static boolean unmarkGroup(int[][] arr, int el, int[] used, int[] cnt){
	    int idx = search(arr, el);
	    if(idx == -1) return false;
	    cnt[idx]--;
	    if(cnt[idx] == 0){
	        used[idx] = 0;
	        return true;
	    }
	    else return false;
	}   
	public static void main(String[] args){
	    int[][] gps = {{0, 10}, {11, 15}, {16, 22}, {23, 34}};
	    int k = gps.length;
	    int[] used = new int[k];
	    int[] usedCnt = new int[k];
	    int cnt = 0;
	    int ans = Integer.MAX_VALUE;
	    int[] arr = {9, 5, 3, 12, 17, 25, 27};
	    int j = 0;
	    for(int i = 0; i < arr.length; i++){
	        if(markGroup(gps, arr[i], used, usedCnt) && cnt < k){
	            cnt++;
	        }

	        while(cnt == k){
	            int len = (i - j + 1);
	            ans = Math.min(ans, len);
	            if(unmarkGroup(gps, arr[j], used, usedCnt))
	                cnt--;
	            j++;
	        }
	    }
	    System.out.println(ans);
	}
}