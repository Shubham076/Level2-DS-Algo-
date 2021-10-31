/*
given an array of integers sort the array first by number of items then the value itself;
[4, 5, 6, 5, 4, 3];
out = [3, 6, 4, 4, 5, 5]
*/
import java.util.*;
class productSort{

    //as we cant override the sorting of primitives
    static void sort(int[] a){
        Integer[] arr = new Integer[a.length];
        for(int i = 0; i < arr.length; i++) arr[i] = a[i];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr, (p,  q) -> {
            if(map.get(p) != map.get(q)){
                return map.get(p) - map.get(q);
            }
            else return p - q;
        });
        for(int i = 0; i < arr.length; i++) a[i] = arr[i];
    }

    static void sort2(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<HashMap.Entry<Integer, Integer>> q = new PriorityQueue<>((a, b) ->
         a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());

        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        q.addAll(map.entrySet());
        int i = 0;
        while(q.size() > 0){
            HashMap.Entry<Integer, Integer> x = q.remove();
            for(int j = 0; j < x.getValue(); j++)
                arr[i++] = x.getKey();
        }
    }
    public static void main(String[] args){
        int[] arr = {8, 5, 5, 5, 5, 5, 1, 1, 1, 4, 4};
        sort2(arr);
        for(int v: arr){
            System.out.print(v + " ");
        }
    }
}