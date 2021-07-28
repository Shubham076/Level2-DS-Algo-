/* leetcode 871
use a max priority to find the best fuelling stops when there is not enought fuel to go to next stop
i is the index of next stops to refuel.
res is the times that we have refeuled.
pq is a priority queue that add all reachable stops

We initial res = 0 and in every loop:

We add all reachable stop to priority queue as we travel
if we cant reach to a particular stop we pop out the largest gas from pq and refuel once.
If we can't refuel, means that we can not go forward and return -1
*/
import java.util.*;
class minimumNumberOfRefuellingStops {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int cnt = 0;
		for (int i = 0; i < stations.length;) {
			int d = stations[i][0];
			int f = stations[i][1];

			if(d <= startFuel){
				q.add(f);
				i++;
			}
			else{
				//no more fuel stops available 
				if(q.size() == 0){
					return -1;
				}
				else{
					startFuel += q.remove(); //refuelling
					cnt++;
				}
			}
		}

		if(target <= startFuel){
			return cnt;

		}
		else{
			while(q.size() > 0){
				startFuel += q.remove();
				cnt++;

				if(target <= startFuel){
					return cnt;
				}
			}
		}

		return -1;
	}
}