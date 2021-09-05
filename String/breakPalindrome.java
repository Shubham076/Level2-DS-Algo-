//leetcode 1328
class breakPalindrome{
    public static String break_palindrome(String palindrome) {
        StringBuilder s = new StringBuilder(palindrome);
        int n = s.length();
        if(n == 1) return "";
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            int j = n - 1 - i;
            if(i == j) continue;  //case of odd length center of string
            if(c != 'a'){
                s.setCharAt(i, 'a');
                return s.toString();
            }
        }

	// for test case "aaaa" aaab < abaa
        s.setCharAt(n - 1, 'b');
        return s.toString();
    }
    public static void main(String[] args){
        String s = "abccba";
        System.out.println(break_palindrome(s)); 
    }   
}