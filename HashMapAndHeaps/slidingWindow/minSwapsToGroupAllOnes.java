class minSwapsToGroupAllOnes{
	public static void main(String[] args){
		int[] arr = {1, 0, 1, 0, 1};
		int cnt = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == 1) cnt++;
		}
		int[] p = new int[arr.length];
		p[0] = arr[0] == 1 ? 1: 0;
		for(int i = 1; i < arr.length; i++){
			p[i] = p[i - 1] + (arr[i] == 1 ? 1 : 0);
		}

		for(int v: p){
			System.out.print(v + " ");
		}
		System.out.println();
		int max = 0;
		int cc = 0;
		//cnt the subarr with max number of ones in window of size cnt
		for(int i = cnt - 1; i < arr.length; i++){
			if(i == cnt - 1) cc = p[i];
			else cc = p[i] - p[i - cnt];
			if(cc > max) max = cc;
		}
		System.out.println(cnt - max);
	}
}