class maximumNumberAfterKSwaps{
	static String max;

	//O(n * n ^ k)
	public static void findMaximum(String str, int k) {
		//write your code here
		if(str.compareTo(max) > 0){
			max = str;
		}

		if(k == 0){
			return;
		}

		for(int i = 0; i < str.length() - 1; i++){
			for(int j = i + 1; j < str.length(); j++){
				StringBuilder sb = new StringBuilder(str);
				char c = sb.charAt(i);
				char d = sb.charAt(j);
				if(d > c){
					sb.setCharAt(i, d);
					sb.setCharAt(j, c);
					findMaximum(sb.toString(), k - 1);
				}
			}
		}
	}

	static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	// O(n ^ k)
	static void maxAfterkSwaps(char[] arr, int k, int i){
		if(k == 0){
			String cur = new String(arr);
			if(cur.compareTo(max) > 0){
				max = cur;
			}
			return;
		}
		char lmax = arr[i];
		for(int j = i + 1; j < arr.length; j++){
			if(arr[j] > lmax){
				lmax = arr[j];
			}
		}
		for(int j = i; j < arr.length; j++){
			if(arr[j] == lmax){
				swap(arr, i, j);
				maxAfterkSwaps(arr, k - 1, i + 1);
				swap(arr, i, j);
			}
		}
	}
	public static void main(String[] args){
		String str = "1234567";
		int k = 4;
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}
}