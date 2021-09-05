import java.util.*;
public class groupShiftedStrings {

    public static String getKey(String s) {
        String key = "";
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i - 1);
            int diff = cur - prev;
            if (diff < 0) {
                diff += 26;
            }
            key += diff + "-";
        }

        key += ".";

        return key;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scn.next();
        }
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for (String s : strs) {
            String key  = getKey(s);
            if (map.containsKey(key)) {
                ArrayList<String> list  = map.get(key);
                list.add(s);
            } else {
                ArrayList<String> list  = new ArrayList<>();
                list.add(s);
                map.put(key , list);
            }
        }

        for (ArrayList<String> s : map.values()) {
            ans.add(s);
        }
        System.out.println(ans);
    }
}
