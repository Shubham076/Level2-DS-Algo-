/*
If two asteroids meet, the smaller one will explode. If both are the same
size, both will explode. Two asteroids moving in the same direction will
never meet.
*/
import java.util.*;
class asteroidCollisions {
	public static int[] asteroidCollisions(int[] arr) {
		Stack<Integer> st = new Stack<>();
		for (int val : arr) {
			if (val > 0) {
				st.push(val);
			}

			else {
				//means values is negative so we check if stack.peek() is
				//positive(means collision and smaller one will explode)
				while (st.size() > 0 && st.peek() > 0 && st.peek() < -val) {
					st.pop();
				}
				if (st.size() > 0 && st.peek() > 0 && st.peek() == -val) {
					st.pop();
				}
				else if (st.size() > 0 && st.peek() > 0 && st.peek() > -val) {
					//means the previous one is greater than val and
				} else {
					st.push(val);
				}
			}
		}
		int[] ans = new int[st.size()];
		int i = ans.length - 1;
		while (st.size() > 0) {
			ans[i--] = st.pop();
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {10, 2, -5};
		int[] ans = asteroidCollisions(arr);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}