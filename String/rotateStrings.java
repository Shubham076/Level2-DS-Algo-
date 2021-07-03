//leetcode 151
import java.util.*;
class rotateStrings{
    public static void reverse(ArrayList<StringBuilder> arr){
        int i = 0; 
        int j = arr.size() - 1;
        while(i < j){
            StringBuilder s = arr.get(i);
            StringBuilder t = arr.get(j);
            arr.set(i, t);
            arr.set(j, s);
            i++;
            j--;
        }
    }
    public static String reverseWords(String s) {
        ArrayList<StringBuilder> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                if(temp.length() != 0)
                    list.add(temp);
                temp  = new StringBuilder("");
                continue;
            }
            else{
                temp.append(c);
            }
        }
        if(temp.length() != 0)
            list.add(temp);
        reverse(list);
        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < list.size(); i++){
            StringBuilder str = list.get(i);
            if(i != list.size() - 1){
                str.append(" ");
            }
            ans.append(str);
        }
        return ans.toString();
    }
    public static void main(String[] args){
        String s = "a hello   world";
        System.out.println(reverseWords(s));
    }
}