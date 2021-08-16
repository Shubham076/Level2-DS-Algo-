import java.util.*;
public class firstNonRepeatingCharacterInAStream {
    public static void solve(String s){
        int[] arr = new int[26];
        StringBuilder ans = new StringBuilder("");
        Queue<Character> q = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            arr[c - 'a']++;
            q.add(c);

            while(q.size() > 0){
                if(arr[q.peek() - 'a'] > 1){
                    q.remove();
                }
                else{
                    ans.append(q.peek());
                    break;
                }
            }
            if(q.size() == 0)
                ans.append('#');
        }
        System.out.println(ans);
    }
    public static void main(String[] args){
        String s = "abac";
        solve(s);
    }
}
