import java.util.*;
// box choses the items(strategy)
//each character is representing the boxes
// 2 choices whether we select the box or not
public class wordKSelection2 {
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

        combination(0, str, k, "");
    }

    public static void combination(int i, String str, int k, String asf) {
        if(i == str.length()){
            if(asf.length() == k){
                System.out.println(asf);
            }
            return;
        }
        combination(i + 1, str, k, asf + str.charAt(i));
        combination(i + 1, str, k, asf);
    }
}
