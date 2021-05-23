public class NaiveStringMatching {

    // time complexity  O(N2)
    public static void main(String[] args) {
        String t = "abcdefgbcdfghabcabcddcbabc";
        String p = "abc";

        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (t.substring(i , i + p.length()).equals(p)) {
                System.out.println("Found at:" + i + " ");
            }
        }
    }
}
