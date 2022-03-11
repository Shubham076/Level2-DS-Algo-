/*
https://www.geeksforgeeks.org/count-of-substrings-having-all-distinct-characters/
*/
public class countsunstringHavingDistinctCharacters {
    public static void main(String[] args){
        String s = "gfg";
        int[] cnt = new int[26];

        int j = 0, i = 0;
        int ans = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            cnt[c - 'a']++;
            while(cnt[c - 'a'] > 1 ){
                cnt[s.charAt(j) - 'a']--;
                j++;
            }
            ans += (i - j + 1);
            i++;
        }
        System.out.println(ans);
    }
}
