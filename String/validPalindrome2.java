//leetcode 680
public class validPalindrome2 {
    public static boolean isValid(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char c = s.charAt(i);
            char d = s.charAt(j);

            if(c != d){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
            char c = s.charAt(i);
            char d = s.charAt(j);

            if(c == d){
                i++;
                j--;
            }
            else{
                //we check if we can form a palindrome by deleting at most 1 character
                //for a valid palindrome extremes must be equal
                if(!isValid(s.substring(i, j)) && !isValid(s.substring(i + 1, j + 1))){
                    return false;
                }
                else{
                    return true;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aba";
        System.out.println(validPalindrome(s));
    }
}
