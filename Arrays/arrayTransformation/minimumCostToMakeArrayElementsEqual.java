//Given an array which contains integer values, we need to make all values of this array equal to some integer value with minimum cost where the cost of changing an array value x to y is abs(x-y). 
import java.util.*;
class minimumCostToMakeArrayElementsEqual{
    public static void main(String[] args){
        int[] arr = {1, 101, 100};
        int cost = 0;
        int n = arr.length;
        Arrays.sort(arr);
        int median = n % 2 == 0 ? (arr[n / 2] + arr[n / 2 - 1]) / 2 : arr[n / 2];
        for(int i = 0; i < arr.length; i++){
            cost += Math.abs(arr[i] - median);
        }
        System.out.println(cost);
    }
}