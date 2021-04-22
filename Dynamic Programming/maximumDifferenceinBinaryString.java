class maximumDifferenceinBinaryString{
	public static void main(String[] args){
		String s = "11000010001";
		int sum = 0;
		int ans = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int val = 0;
			if(c == '1'){
				val = -1;
			}
			else{
				val = 1;
			}

			if(sum >= 0){
				sum += val;
			}
			else sum = val;

			if(sum > ans) ans = sum;
		}
		System.out.println(ans);
	}
}