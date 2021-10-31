//https://www.geeksforgeeks.org/find-the-interval-which-contains-maximum-number-of-concurrent-meetings/
import java.util.*;
public class IntervalWithMaxNumberOfmeetings {
    public static void main(String[] args){
        int[][] arr = {{100, 300}, {145, 215}, {200, 230}, {215, 300}, {215, 400}, {500, 600}, {600, 700}};
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Queue<Integer> q = new PriorityQueue<>();

        //add the end time of first meeting
        // q.add(arr[0][1]);
        int cnt = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            int ms = arr[i][0];
            int me = arr[i][1];
            
            // Pop all meetings that end before current meeting
            while(q.size() > 0 && ms >= q.peek()){
                q.remove();
            }

            q.add(me);

            if(q.size() > cnt){
                cnt = q.size();
                start = ms;
                end = q.peek();
            }
        }
        System.out.println("Max Number of meeting: " + cnt);
        System.out.print("Meeting start: " + start + " ");
        System.out.print("Meeting end: " + end);
    }
}
