//leetcode 171
class excelColumnNumberFromName {
	public static  int titleToNumber(String s) {
		//converting from base 26 => 10
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			num *= 26;
			num += s.charAt(i) - 'A' + 1;
		}
		return num;
	}
	public static void main(String[] args) {
		String s = "AZ";
		System.out.println(titleToNumber(s));
	}
}