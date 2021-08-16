/*
given array of integers the cost to change an element is the difference between
new and old number. Find the minimum cost to make array either ascending or
descending along its length.

for eg = arr = [0, 1, 2, 5, 6, 5, 7];
ans = 1 we can change 5 -> 6;
*/
import java.util.*;
public class minmumCostToMakeArraySorted {
    public static int makeDecreasingArray(int[] arr){
        Queue<Integer> min = new PriorityQueue<>();
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            if(min.size() > 0 && min.peek() < arr[i]){
                int diff = arr[i] - min.peek();
                cost += diff;
                min.remove();
                min.add(arr[i]);
            }
            min.add(arr[i]);
        }
        return cost;
    }
    public static int makeIncreasingArray(int[] arr){
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        int cost = 0;
        for(int i = 0; i < arr.length; i++){
            if(max.size() > 0 && max.peek() >= arr[i]){
                int diff = max.peek() - arr[i];
                cost += diff;
                max.remove();
                max.add(arr[i]);
            } 
            max.add(arr[i]);
        }
        return cost;
    }

    public static int minCost(int[] arr){
        return Math.min(makeDecreasingArray(arr), makeIncreasingArray(arr));
    }
    public static void main(String[] args){
        int[] arr = {9847,3752,5621,7012,1986,3090,1383,6257,9501,7004,6181,9387,9137,9305,7795,9310,3904,8328,6656,8123,1796,2754,4372,5200,3893,8568,4436,3973,8498,1879,2731, 4651,4388,453,2465,2669,6384,819,8565,1952,7219,4362,3012,9380,2645,4800,2945,5778,1993,1170,1356,8557,1497,8921,670,5155,9115,1095,9400,9451,9344,4393, 4201,8167,8129,2004,8839,1457,7682,1881,9266,6366,9889,242,5318,5248,3670,7381,6567,2317,2162,6670,5876,1179,2482,9270,4326,4166,6122,2016,3008,5349,1723, 5816,4030};
        int ans = minCost(arr);
        System.out.println(ans);
    }    
}
