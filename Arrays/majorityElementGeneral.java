// Given an array of size n and a number k, find all elements that appear more than n/k times
import java.util.*;
public class majorityElementGeneral {
    public static void main(String[] args){
        int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
        int k = 4;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i , map.getOrDefault(i, 0) + 1);
        }

        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(HashMap.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > n / k){
                ans.add(m.getKey());
            }
        }
        System.out.println(ans);
    }
}
