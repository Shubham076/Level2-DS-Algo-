//we have to find the length of longest subarray with at max 2 unique elements
import java.util.*;
public class fruitBasket {
    public static int totalFruit(int[] fruits) {
        int ans = Integer.MIN_VALUE;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < fruits.length; i++){
            int v = fruits[i];
            map.put(v, map.getOrDefault(v, 0) + 1);

            //releasing the fruits
            while(map.size() > 2){
                int n = fruits[j++];
                int freq = map.get(n);
                if(freq > 1){
                    map.put(n, freq - 1);
                }
                else{
                    map.remove(n);
                }
            }
            int len = i - j + 1;
            if(len > ans){
                ans = len;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {0, 1, 2, 2};
        int ans = totalFruit(arr);
        System.out.println(ans);
    }
}
