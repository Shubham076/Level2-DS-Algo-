import java.util.Arrays;
import java.util.Comparator;

class Meeting {
    int start, end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class maxNonOverlappingMeetings {

    public static int findMaxMeetings(Meeting[] meetings) {
        // Sort the meetings based on their end times
        Arrays.sort(meetings, Comparator.comparingInt(a -> a.end));

        int count = 1;  // Always take the first meeting after sorting
        int lastEndTime = meetings[0].end;

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i].start > lastEndTime) {
                count++;
                lastEndTime = meetings[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Meeting[] meetings = {
            new Meeting(1, 4),
            new Meeting(2, 5),
            new Meeting(6, 8),
            new Meeting(7, 9),
            new Meeting(9, 11)
        };

        int result = findMaxMeetings(meetings);
        System.out.println(result);  // Expected output: 3
    }
}
