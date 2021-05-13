//leetcode 43
class multipyStrings{
	//max length of multiplication of 2 numbers is sum of length of both numbers
	//after product of 2 numbes the carry or quotient is stored at idx1 and remainder is stored at idx2
	public static String multiply(String num1, String num2) {
		int n = num1.length();
		int m = num2.length();
		int[] ans = new int[n + m];
		int val = 1;
		for(int i = n - 1; i >= 0; i--){
			for(int j = m - 1; j >= 0; j--){
				int idx1 = i + j;
				int idx2 = i + j + 1;
				val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				val += ans[idx2];

				int r = val % 10;
				int q = val / 10;
				ans[idx2] = r;
				ans[idx1] += q;
			}
		}

		String a = "";
		for(int i = 0; i < ans.length; i++){
			if(a.length() == 0 && ans[i] == 0){
				continue;
			}
			a += ans[i];
		}

		return a.length() != 0 ? a : "0";        
    }
	public static void main(String[] args) {
		String s1 = "050";
		String s2 = "5";
		System.out.println(multiply(s1, s2));
	}
}