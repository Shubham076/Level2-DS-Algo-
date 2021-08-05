//leetcode 85
class maximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) return 0;
		return maxRectangle(matrix);
	}

	public static int maxHistogram(int[] arr) {
		int max = 0;
		int area = 0;
		Stack<Integer> stack = new Stack<>();
		int[] rb = new int[arr.length];

		stack.push(arr.length - 1);
		rb[arr.length - 1] = arr.length;

		for (int i = arr.length - 2; i >= 0 ; i--) {
			while ( stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}

			if ( stack.size() == 0) rb[i] = arr.length;
			else rb[i] = stack.peek();
			stack.push(i);
		}

		int[] lb = new int[arr.length];
		lb[0] = -1;
		stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < arr.length ; i++) {
			while ( stack.size() > 0 && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			if ( stack.size() == 0) lb[i] = -1;
			else lb[i] = stack.peek();

			stack.push(i);
		}

		for (int i : lb) {
			System.out.print(i + " ");
		}

		for (int i : rb) {
			System.out.print(i + " ");
		}

		for (int i = 0; i < arr.length ; i++) {
			int width = rb[i] - lb[i] - 1;
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