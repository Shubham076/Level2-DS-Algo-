//https://www.geeksforgeeks.org/minimize-cash-flow-among-given-set-friends-borrowed-money/  O(nlogn)
import java.util.*;
class minimizeCashFlowBetweenFriends {
	static class Pair implements Comparable<Pair> {
		int n; //person
		int a; //amount
		Pair(int n, int a) {
			this.n = n;
			this.a = a;
		}
		public int compareTo(Pair o) {
			return this.a - o.a;
		}
	}
	public static void main(String[] args) {
		int[][] arr = {{0, 100, 0, 200}, {0, 0, 300, 0}, {0, 0, 0, 200}, {0, 0, 0, 0}};
		int[][] ans = new int[4][4];
		//arr[i][j] representing a flow of cash
		Queue<Pair> debit = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Pair> credit = new PriorityQueue<>(Collections.reverseOrder());
		int[] net = new int[10]; //net amount 10 is max cnt of friends assumption
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					net[i] -= arr[i][j];
					net[j] += arr[i][j];
				}
			}
		}
		for (int i : net) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < net.length; i++) {
			if (net[i] < 0) {
				debit.add(new Pair(i, -net[i]));
			} 
			else if (net[i] > 0) {
				credit.add(new Pair(i, net[i]));
			}
		}

		while (debit.size() > 0 && credit.size() > 0) {
			Pair d = debit.remove();
			Pair c = credit.remove();

			int sment_amount = Math.min(d.a, c.a); //settlement amount
			System.out.println(d.n + " gives " + sment_amount + " to " + c.n);
			d.a -= sment_amount;
			c.a -= sment_amount;
			if (d.a != 0) {
				debit.add(d);
			}
			if (c.a != 0) {
				credit.add(c);
			}
		}
	}
}