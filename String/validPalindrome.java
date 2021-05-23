//leetcode 125
public class validPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            while(i <= j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while(i <= j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if( i <= j && s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        String s = ".";
        s = s.toLowerCase();
        System.out.println(isPalindrome(s));
    }    
}
