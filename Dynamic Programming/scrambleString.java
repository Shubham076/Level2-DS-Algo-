//leetcode 87
/*
scrambling is diff from permutation
for eg str = great
we can make a cut and swap the 2 cuts
for eg great => gr eat => eatgr valid scramble
breaking can be done at any level
and swapping can be done at any level

*/
import java.util.*;
public class scrambleString {
    static HashMap<String, Boolean> dp;

    public static boolean isScramble(String s1, String s2){
        dp = new HashMap<>();
        return helper(s1, s2);
    }
    //recursion + memoization
    public static boolean helper(String s1, String s2) {
        String k = s1 + s2;  //always going to be unique as both s1 and s2 are of same length
        if(dp.containsKey(k)){
            return dp.get(k);
        }
        //base case
        if(s1.equals(s2)){
            return true;
        }

        //now check if both the strings contains same characters or not
        int[] freq1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }

        int[] freq2 = new int[26];
        for(int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            freq2[c - 'a']++;
        }
        
        for(int i = 0; i < 26; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        //diving the string about each index
        for(int i = 1; i < s1.length(); i++){
            boolean temp1 = helper(s1.substring(0, i), s2.substring(0, i));
            boolean temp2 = helper(s1.substring(i), s2.substring(i));

            //if left part is scrambled ad right part is also scrambled 
            if(temp1 && temp2){
                dp.put(k, true);
                return true;
            }

            //otherwise lets try with the swapping;
            /*  
            for eg = >
                0 1 2 3 4                  0 1 2 3 4 
                g r e a t                  r g e a t
                i = 2;
                gr  eat               rg  eat

                comparing gr with eat
                and comparing  eat rg
            */
            boolean temp3 = helper(s1.substring(0, i), s2.substring(s2.length() - i));
            boolean temp4 = helper(s1.substring(i), s2.substring(0, s2.length() - i));

            //after swapping if left part is also scrambled ad right part is also scrambled 
            if(temp3 && temp4){
                dp.put(k, true);
                return true;
            }
        }
        dp.put(k, false);
        return false;   
    }

    public static void main(String[] args){
        String s1 = "great";
        String s2 = "rgeat";
        boolean ans = isScramble(s1, s2);
        System.out.println(ans);
    }
}
