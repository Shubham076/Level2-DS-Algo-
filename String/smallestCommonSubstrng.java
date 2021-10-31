/*
You are given two strings A and B that are made of lowercase English alphabets. Find the number of different pairs ((i,j), (k,l)) such that the substrings A[i…j] and B[k…l] are equal and the value of j-i+1 is minimum.
min value of j-i+1 == 1;
*/
public class smallestCommonSubstrng {
    public static void main(String[] args){
        String s = "abcd";
        String p = "bc";
        int cnt = 0;
        int[] freq = new int[256];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freq[c]++;
        }

        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            cnt += freq[c];
        }
        System.out.println(cnt);
    }
}
