//leetcode 1163
public class lastsubstringInLexicographicalOrder {
    public String lastSubstring(String s) {
        int max = s.charAt(0);
        for (char c : s.toCharArray()) {
            max = c > max ? c : max;
        }

        String res = s.substring(0);

        for (int i = 0; i < s.length(); i++) {

            // skip if pre character is same
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    continue;
                }
            }

            // check if suffix starts with max charcter
            if (s.charAt(i) == max) {
                String curr = s.substring(i);

                if (curr.compareTo(res) > 0) {
                    res = curr;
                }
            }
        }
        return res;
    }
}
