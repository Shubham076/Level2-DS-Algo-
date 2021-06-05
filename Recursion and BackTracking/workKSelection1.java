import java.util.*;
public class workKSelection1 {
    public static void main(String[] args) throws Exception {
        String s = "abc";
        int k = 2;

        HashSet<Character> unique = new HashSet<>();
        String str = "";
        for (char ch : s.toCharArray()) {
            if (!unique.contains(ch)) {
                unique.add(ch);
                str += ch;
            }
        }

        combination(-1, str, k, "");
    }

    public static void combination(int li, String str, int k, String asf) {
        if(asf.length() == k){
                System.out.println(asf);
                return;
        }
        for(int i = li + 1; i < str.length(); i++){
            combination(i + 1, str, k, asf + str.charAt(i));
        }
    }
}
