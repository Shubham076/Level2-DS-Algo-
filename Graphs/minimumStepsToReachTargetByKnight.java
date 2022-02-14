//https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
import java.util.*;
class minimumStepsToReachTargetByKnight{
	public static int minSteps(int n, int[] k, int[] t){
		int steps = 0;
		int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
		Queue<int[]> q = new ArrayDeque<>();
		q.add(k);
		HashSet<String> vis = new HashSet<>();
		vis.add(k[0] + "" + k[1]);
		while(q.size() > 0){
			int s = q.size();
			while(s-- > 0){
				int[] rm = q.remove();
				if(rm[0] == t[0] && rm[1] == t[1]){
					return steps;
				}
				for(int[] dir: dirs){
					int x = rm[0] + dir[0];
					int y = rm[1] + dir[1];
					if(x >= 0 && y >= 0 && x < n && y < n && !vis.contains(x + "" + y)){
						q.add(new int[]{x, y});
						vis.add(x + "" + y);
					}
				}
			}
			steps++;
		}
		return -1;
	}
	public static void main(String[] args){
		int n = 30;
		int[] k = {0, 0};
		int[] t = {29, 29};
		System.out.println(minSteps(n, k, t));
	}
}