//string is binary
class minNumberOfFlipsToMakeStringAlternating {
	public static char flip(char c) {
		return c == '0'  ? '1' : '0';
	}
	public static int getFlipWithStartingCharcter(String str, char expected) {
		int flipCount = 0;
		for (int i = 0; i < str.length(); i++) {
			//if current character is not expected,
			// increase flip count
			if (str.charAt(i) != expected)
				flipCount++;

			//  flip expected character each time
			expected = flip(expected);
		}
		return flipCount;
	}
	public static int minimumFlips(String s) {
		return Math.min(getFlipWithStartingCharcter(s, '1') , getFlipWithStartingCharcter(s, '0'));
	}
	public static void main(String[] args) {
		String s = "0001010111";
		System.out.println(minimumFlips(s));
	}
}