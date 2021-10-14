//leetcode 85
import java.util.*;
class maximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) return 0;
		return maxRectangle(matrix);
	}

	public static int maxHistogram(int[] arr) {
		int max = 0;
		int area = 0;
		int[] nsl = new int[arr.length]; //next smaller on the left
		int[] nsr = new int[arr.length]; //next smaller on the right;
		Stack<Integer> s = new Stack<>();
		nsr[arr.length - 1] = arr.length;
		nsl[0] = -1;

		s.push(0);
		for(int i = 1; i < arr.length; i++){
			while(s.size() > 0 && arr[i] < arr[s.peek()]){
				int idx = s.pop();
				nsr[idx] = i;
			}
			s.push(i);
		}

		while(s.size() > 0){
			int idx = s.pop();
			nsr[idx] = arr.length;
		}

		s = new Stack<>();
		s.push(arr.length - 1);
		for(int i = arr.length - 2; i >= 0; i--){
			while(s.size() > 0 && arr[i] < arr[s.peek()]){
				int idx = s.pop();
				nsl[idx] = i;
			}
			s.push(i);
		}

		while(s.size() > 0){
			int idx = s.pop();
			nsl[idx] = -1;
		}
		for (int i = 0; i < arr.length ; i++) {
			int width = nsr[i] - nsl[i] - 1;
			int height = arr[i];
			area  = width * height;
			max = Math.max(max , area);
		}
		return max;
	}

	public static int maxRectangle(char[][] input) {
		int max = 0;
		int area = 0;
		int[] board = new int[input[0].length];

		for (int i = 0; i < input.length ; i++) {
			for (int j = 0; j < input[0].length ; j++) {
				if (input[i][j] == '0') {
					board[j] = 0;
				}
				else {
					board[j] += input[i][j] - '0';
				}
			}
			area = maxHistogram(board);
			max = Math.max(max , area);
		}
		return max;
	}
}