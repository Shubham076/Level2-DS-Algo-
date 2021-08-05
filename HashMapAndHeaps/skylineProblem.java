/*
leetcode 218
as we have to find the starting point of each horizontal line in the boundary of the buildings or 
we have to return the points when there is height change
algorithm:
create starting and the ending point of each rectangle in the list
to differentiate between start and end we use signs =>  -ve height for start and positive height for end of rectangle
now sort the point according to the x coordinnates.
now travel one by one
** create a priority queue which stores the current height we are travelling right now
if start point is encounter put it in the priority queue(max);
if end point is encounter remove the height from the height
in this way at any time we have the height at which we are trvelling stored in the queue.
and whenever there is a change in the height it means that is a valid point  of the skyline 
*/
import java.util.*;
public class skylineProblem {
    static class Pair{
        int x;
        int h;
        Pair(int x, int h){
            this.x = x;
            this.h = h;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] b: buildings){
            int s = b[0];  //start
            int e = b[1]; //end
            int h = b[2]; //height
            list.add(new Pair(s, -h));
            list.add(new Pair(e, h));
        }
        Collections.sort(list, (a, b) -> {
            if(a.x != b.x){
                return a.x - b.x;
            }
            else{
                return a.h - b.h;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int prevHeight = 0;
        pq.add(0);

        for(Pair p: list){
            if(p.h < 0){  //negative height starting of reactangle
                pq.add(-p.h);
            }
            else{
                pq.remove(p.h);
            }

            if(prevHeight != pq.peek()){
                //if previous height  is not equal to height we are now => means there is a height change
                ans.add(Arrays.asList(p.x , pq.peek()));
                prevHeight = pq.peek();
            }
        }
        return ans;
    }
}
