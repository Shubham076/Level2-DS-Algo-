//leetcode 632
// Find the smallest range that includes at least one number from each of the k lists.
import java.util.*;
class smallestRangeFromKList {
	static class Pair implements Comparable<Pair> {
		int i;
		int j;
		int v;
		Pair(int i, int j, int v) {
			this.i = i;
			this.j = j;
			this.v = v;
		}
		@Override
		public int compareTo(Pair o) {
			return this.v - o.v;
		}
	}
	public static int[] smallestRange(int[][] nums) {
		int[] ans = {0, 0};
		int max = Integer.MIN_VALUE;
		int range = Integer.MAX_VALUE;
		PriorityQueue<Pair> p = new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			p.add(new Pair(i , 0, nums[i][0]));
			max = Math.max(max , nums[i][0]);
		}

		while (true) {
			Pair rp = p.remove();
			int curRange = max - rp.v + 1;
			if (curRange < range) {
				range = curRange;
				ans[0] = rp.v;
				ans[1] = max;
			}

			int r = rp.i;
			int c = rp.j + 1;
			if (c < nums[r].length) {
				p.add(new Pair(r, c, nums[r][c]));
				max = Math.max(max, nums[r][c]);
			}
			else{
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[][] arr = {{4, 10, 15, 24, 26}, {0, 9, 12, 20}, {5, 18, 22, 30}};
		int[] ans = smallestRange(arr);
		System.out.println(ans[0] +  " " + ans[1]);
	}
}