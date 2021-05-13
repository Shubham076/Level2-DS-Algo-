//leetcode 56
import java.util.*;
class mergeIntervals{
	public static int[][] merge(int[][] intervals) {
     	ArrayList<int[]> ans = new ArrayList<>();
     	Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
     	int[] prev = intervals[0];
     	ans.add(prev);
     	for(int i = 1; i < intervals.length; i++){
     		int[] cur = intervals[i];
     		int prevEnd = prev[1];
     		int curStart = cur[0];
     		int curEnd = cur[1];

     		if(curStart <= prevEnd){
     			prev[1] = Math.max(prevEnd, curEnd);
     		}
     		else{
     			ans.add(cur);
     			prev = cur;
     		}

     	}   
     	return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args){
    	int[][] intervals = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] ans = merge(intervals);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}