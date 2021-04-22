import java.util.*;

public class goldmine {
	static int max = 0;

	public static void collectgold(int[][] arr , int row , int col , boolean[][] visited , ArrayList<Integer> bag) {

		if (row < 0 || col < 0 || row > arr.length - 1 || col > arr[0].length - 1 || arr[row][col] == 0 || visited[row][col] == true) {
			return;
		}

		visited[row][col] = true;
		bag.add(arr[row][col]);

		collectgold(arr , row - 1 , col , visited , bag );
		collectgold(arr , row , col + 1 , visited , bag );
		collectgold(arr , row , col - 1 , visited , bag );
		collectgold(arr , row + 1 , col , visited , bag );
	}


	public static void getMaxGold(int[][] arr) {
		//write your code here
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		int m = arr.length;
		int n = arr[0].length;

		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n; j++) {
				ArrayList<Integer> bag = new ArrayList<>();
				if (arr[i][j] != 0 && visited[i][j] == false ) {
					collectgold(arr , i , j , visited , bag);
					int sum = 0;
					for (int val : bag) {
						sum += val;
					}

					if ( sum > max) {
						max = sum;
					}
				}
			}
		}

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
	}

}