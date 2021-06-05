class maximumNumberAfterKSwaps{
	static String max;
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
	public static void main(String[] args){
		String str = "1234567";
		int k = 4;
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}
}