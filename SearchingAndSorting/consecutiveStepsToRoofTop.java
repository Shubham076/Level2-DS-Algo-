//gfg
class consecutiveStepsToRoofTop {
	static int maxStep(int a[], int n) {
		int max = 0;
		int cnt = 0;
		for(int i = 0; i < n - 1; i++){
			if(a[i] < a[i + 1]){
				cnt++;
			}
			else{
				max = Math.max(max, cnt);
				cnt = 0;
			}
		}
		max = Math.max(max, cnt);
		return max;
	}
	public static void main(String[] args) {
		int[] arr = {5, 7};
		System.out.println(maxStep(arr, arr.length));
	}
}