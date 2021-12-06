/*
remove characters from string that appears consecutively k times
ed aabbccdef k = 1 .=> outut aabbcc
eg = aabbbaaa k = 2 => outut => bbbaaa
eg = abcd k = 2 => abcd
*/
class truncateString {
    public static void solve(String s, int k) {
        StringBuilder ans = new StringBuilder("");
        char c = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            char d = s.charAt(i);
            if (c == d) {
                cnt++;
            } 
            else {
                if (cnt != k) {
                    while (cnt-- > 0) {
                        ans.append(c);
                    }
                }
                cnt = 1;
                c = d;
            }
        }

        int n = s.length();
        if (c == s.charAt(n - 1) && cnt != k) {
            while (cnt-- > 0)
                ans.append(c);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        String[] s = { "aabbccdef", "aabbbaaa", "abcd" };
        int[] k = { 1, 2, 2 };
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            int n = k[i];
            solve(str, n);
        }
    }
}