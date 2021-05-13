// lintcode 920
import java.util.*;
class meetingRooms {
	static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static boolean canAttendMeetings(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return true;
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		Interval prev = intervals.get(0);

		for(int j = 1; j < intervals.size(); j++){
			Interval cur = intervals.get(j);
			if(cur.start < prev.end){
				return false;
			}
			prev = cur;
		}
		return true;
	}
	public static void main(String[] args) {
		List<Interval> arr = new ArrayList<>();
		arr.add(new Interval(0, 30));
		arr.add(new Interval(5, 10));
		arr.add(new Interval(15, 20));
		System.out.println(canAttendMeetings(arr));
	}
}