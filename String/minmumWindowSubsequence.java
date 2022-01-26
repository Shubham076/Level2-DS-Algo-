/*
leetcode 727 lintocode 857
Given strings S and T, find the minimum (contiguous) substring W of S,
 so that T is a subsequence of W.
If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the smallest starting index.
Input：S = "abcdebdde"， T = "bde"
Output："bcde"
o(n * n) o(1) space
*/
public class minmumWindowSubsequence {

    public static int backtrack(String s, String t, int idx){
        int j = t.length() - 1;
        int i = -1;
        for(i = idx; i >= 0; i--){
            char c = s.charAt(i);
            char d = t.charAt(j);
            if(c == d){
                j--;
            }

            if(j == -1){
                break;
            }
        }
        return i;
    }
    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int end = -1;
        int start = -1;
        int j = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            char d = t.charAt(j);

            if(c == d){
                j++;

                if(j == m){
                    start = backtrack(s, t, i);
                    end = i + 1;

                    //now we have found one start searching for new one
                    j = 0;
                    i = start;
                    //compete cur ans with the global min
                    if(end - start < min){
                        min = end - start;
                        ans = s.substring(start, end);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "shubhambsfhrehtu";
        String p = "shu";
        System.out.println(minWindow(s, p));
    }
}
