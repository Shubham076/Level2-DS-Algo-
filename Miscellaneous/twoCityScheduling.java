/*leetcode 1029
we will calculate the profit value for each candidate(cos[b] - cost[a]) 
and since we want to maximize the profit so we sort the costs in decreasng order
of profit value;  
*/
import java.util.*;
class twoCityScheduling {
	public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> {
        	return b[1] - b[0] - (a[1] - a[0]);
        });

        int sum = 0;
        int n = costs.length;
        for(int i = 0; i < n; i++){
        	sum += i >= n / 2 ? costs[i][1] : costs[i][0]; 
        }
        return sum;
    }
	public static void main(String[] args) {
		int[][] arr =  {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
		System.out.println(twoCitySchedCost(arr));
	}
}