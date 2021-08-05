/*
lintcode 850
We are given a list schedule of employees, which represents the working time for each employee.
Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
The Intervals is an 1d-array.Each two numbers shows an interval. For example, [1,2,8,10] represents that the employee works in [1,2] and [8,10].
Input：schedule = [[1,2,5,6],[1,3],[4,10]]
Output：[(3,4)]
Explanation:
There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.

algorithm 
first we add all the intervals and sort them according to their start time
we start from i = 1;
and check if the start time of cur > end time of prev means we have an empty or free time
O(Nlogn) + o(n) where n is the number of intervals
*/
import java.util.*;
class employeeFreeTime {
	public class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public List<Interval> employeeFreeTime(int[][] schedule) {
		List<Interval> list = new ArrayList<>();
		for (int[] arr : schedule) {
			for (int i = 0; i < arr.length - 1; i += 2) {
				list.add(new Interval(arr[i], arr[i + 1]));
			}
		}

		Collections.sort(list, (a, b) -> {
			if(a.start != b.start){
				return a.start - b.start; 
			}
			else{
				return a.end - b.end;
			}
		});
		List<Interval> ans = new ArrayList<>();
		Interval prev = list.get(0);
		for(int i = 1; i < list.size(); i++){
			Interval cur = list.get(i);

			if(cur.start > prev.end){
				//free time
				ans.add(new Interval(prev.end, cur.start));
			}

			prev.end = Math.max(prev.end, cur.end);
		}
		return ans;
	}
}