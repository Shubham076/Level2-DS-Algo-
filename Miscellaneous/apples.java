/*
Yash has two types of apples that have some sweetness level. He has N apples
of the first type which costs her P rupees each and M apples of the second
type which costs her Q rupees each. He wants to pick apples in such a way
that the total sum of sweetness level is equal to or more than X and the
total cost is minimum. The first line of input contains 5 integers N, M, P,
Q, X separated by spaces. The second line of input contains N Space-
separated integers depicting the sweetness level of the first type of apples.
The last line of input contains M space- separated integers depicting the
sweetness level of the second type of apples.

Test Case 1:
Input:
  5 5 1 2 16
  1 2 3 4 5
  3 2 1 8 7
Output: 4 Explanation:
From first type:- 4, 5
From second type:- 8
*/
import java.util.*;
class apples {
	static int min = 0;
	static int pcost;
	static int qcost;
	public static void main(String[] args) {
		min = Integer.MAX_VALUE;
		pcost = 1;
		qcost = 2;
		int x = 16;
		Integer[] p = {1, 2, 3, 4, 5};
		Integer[] q = {3, 2, 1, 8, 7};
		Arrays.sort(p, Collections.reverseOrder());
		Arrays.sort(q, Collections.reverseOrder());
		solve(0, 0, p, q, x, 0, 0);
		System.out.println(min);
	}
	public static void solve(int i, int j, Integer[] p, Integer[] q, int x, int sum, int cost){
		if(i == p.length || j == q.length){
			return;
		}

		if(sum >= x){
			min = Math.min(min, cost);
			return;
		}

		solve(i + 1, j + 1, p, q, x, sum + p[i] + q[j], cost + pcost + qcost);
		solve(i + 1, j, p, q, x, sum + p[i], cost + pcost);
		solve(i, j + 1, p, q, x, sum + q[j], cost + qcost);
	}
}