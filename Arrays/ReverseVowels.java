//leetcode 345
import java.util.*;
public class ReverseVowels {
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char c: vowels){
            set.add(c);
        }
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            char c = arr[i];
            char d = arr[j];
            if(!set.contains(c)){
                i++;
                continue;
            }
            if(!set.contains(d)){
                j--;
                continue;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return new String(arr);
    }
    public static void main(String[] args){
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
}
