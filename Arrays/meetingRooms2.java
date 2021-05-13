//lintcode 919
import java.util.*;
class meetingRooms2{
	static class Interval {
		int start, end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	public static int canAttendMeetings(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return 0;
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> end = new ArrayList<>();
		for(Interval i : intervals){
			start.add(i.start);
			end.add(i.end);
		}
		Collections.sort(start);
		Collections.sort(end);
		int i = 0, j = 0;
		int cnt = 0;
		int total = 0;
		while(i < intervals.size()){
			if(start.get(i) <= end.get(j)){
				cnt++;
				i++;
			}
			else{
				cnt--;
				j++;
			}

			total = Math.max(total, cnt);
		}
		return total;
	}
	public static void main(String[] args) {
		List<Interval> arr = new ArrayList<>();
		arr.add(new Interval(0, 30));
		arr.add(new Interval(5, 10));
		arr.add(new Interval(15, 20));
		System.out.println(canAttendMeetings(arr));
	}

	// 0  5  15
	// 10 20 30
}