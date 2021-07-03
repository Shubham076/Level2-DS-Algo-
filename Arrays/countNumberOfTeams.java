//leetcode 1395
class countNumberOfTeams {
	// O(n ^ 3)
	public static int num_Teams(int[] arr) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				for (int k = 0; k < j; k++) {
					if ((arr[i] < arr[j] && arr[j] < arr[k]) || (arr[i] > arr[j] && arr[j] > arr[k])) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}


	/* O(N^2)
	For each soldier, count how many soldiers on the left and right have less and greater ratings.
	This soldier can form less[left] * greater[right] + greater[left] * less[right] teams.
	*/
	public static int numTeams(int[] arr) {
		int n = arr.length;
		int cnt = 0;
		for (int i = 1; i < n; i++) {
			//why variables are inside coz we are calculating for each soldier
			int ls = 0; //left smaller
			int lg = 0; //left greater
			int rs = 0; //right smaller
			int rg = 0; //right greater
			for (int j = 0; j < n; j++) {

				if (j < i) {
					if (arr[j] < arr[i]) {
						ls++;
					} else if (arr[j] > arr[i]) {
						lg++;
					}
				} else if ( j > i) {
					if (arr[j] > arr[i]) {
						rg++;
					} else if (arr[j] < arr[i]) {
						rs++;
					}
				}
			}
			cnt +=  ls * rg + lg * rs;
		}
		return cnt;
	}
	public static void main(String[] args) {
		int[] arr = {2, 5, 3, 4, 1};
		System.out.println(num_Teams(arr));
		System.out.println(numTeams(arr));
	}
}