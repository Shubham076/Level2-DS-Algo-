//leetcode 1358
public class countOfSubstringContainingall3characters {
    public static int numberOfSubstrings(String s) {
        int[] cnt = {0, 0, 0};
        int ans = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;

            //releasing the character
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                char d = s.charAt(j++);
                cnt[d - 'a']--;
            }
            ans += j;
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "abcabc";
        int ans = numberOfSubstrings(s);
        System.out.println(ans);
    }
}
