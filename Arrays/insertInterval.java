import java.util.*;
class insertInterval {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> ans = new ArrayList<>();
		int i = 0;

		//add all the intervals which are smaller (start of newInterval is greater than end of interval[i].end)
		while(i < intervals.length && newInterval[0] > intervals[i][1]){
			ans.add(intervals[i]);
			i++;
		}

		//now we have 2 cases either the intervals got empty or we have overlapping of intervals
		while(i < intervals.length && intervals[i][0] <= newInterval[1]){
			int[] cur = intervals[i];
			newInterval[0] = Math.min(cur[0], newInterval[0]); 
			newInterval[1] = Math.max(cur[1], newInterval[1]);
			i++;
		}

		//now add union of intervals we have got
		ans.add(newInterval);

		//add the remaining ones;
		while(i < intervals.length){
			ans.add(intervals[i]);
			i++;
		}

		return ans.toArray(new int[ans.size()][]);
	}
	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {6, 9}};
		int[] interval = {2, 5};
		int[][] ans = insert(intervals, interval);

		for(int i = 0; i < ans.length; i++){
			for(int j = 0; j < ans[0].length; j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}