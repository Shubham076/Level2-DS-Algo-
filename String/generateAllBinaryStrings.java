class generateAllBinaryStrings{
	//exponential time complexity
	public static void generate(int i, String s, String asf){
		if(i == s.length()){
			System.out.println(asf);
			return;
		}
		char c = s.charAt(i);
		if(c == '?'){
			generate(i + 1, s, asf + '0');
			generate(i + 1, s, asf + '1');
		}
		else{
			generate(i + 1, s, asf + c);
		}
	}
	public static void main(String[] args) {
		String s = "??";
		generate(0, s, "");
	}
}