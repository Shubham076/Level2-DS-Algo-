/*
leetcode 10
'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
*/
public class RegularExpressionMatching {
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        
        //filling the first col
        for (int i = 1; i < dp.length; i++) {
            if (p.charAt(i - 1) == '*'){
                    dp[i][0] = dp[i - 2][0];
                }
            }
        
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++){

                if(p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                /*
                case of *
                so first we have to check that the character before * is equal to last character in string
                if not then mis* have only becomes mi all the other options are not possible
                why see in the eg below :-

                for eg s = ab
                       p = a*

                       as we can see above example character before * is not equal to last character in string
                       there is no way we can match s with p can become _, a, aa, aaa, aaa

                if character before * is equal to last character in string
                for eg 
                s = miss
                p = mis*
                so we check two options:
                1: when s* becomes blank so problem reduces to find the answer of miss && mi
                2: in second case we check if mis* matches with mis if its true than mis* can also satisfy miss
                why because mis* => mi, mis, miss, misss.... 
                */

                else if(p.charAt(i - 1) == '*'){
                    if(p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.'){
                        dp[i][j] = dp[i - 2][j] || dp[i][j - 1];
                    }
                    else{
                        dp[i][j] = dp[i - 2][j];
                    }
                }
            }
        }
        System.out.println(dp[p.length()][s.length()]);
    }
}