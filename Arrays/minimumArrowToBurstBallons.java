import java.util.*;
// O(N)
//leetcode 452
class minimumArrowToBurstBallons{
	//intution merging of the intervals
	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int ans = 1;
        int[] prev = points[0];
        for(int i = 1; i < points.length; i++){
        	int[] cur = points[i];
        	int fs = prev[0];
        	int fe = prev[1];
        	int ss = cur[0];
        	int se = cur[1];

        	if(fs <= se && ss <= fe){
        		// means intervals are overlapping
        		//means previous arrow have burst this one also
        		//dont need new arrow for this one
        		continue;
        	}

        	ans++;
        	prev = cur;
        }
        return ans;
    }
	public static void main(String[] args) {
		int[][] points = {{10, 16}, {2, 8}, {1, 6}};
		System.out.println(findMinArrowShots(points));
	}
}