/*
https://practice.geeksforgeeks.org/problems/smallest-subarray-with-all-occurrences-of-a-most-frequent-element2258/1
Given an array, A. Let x be an element in the array. x has the maximum frequency in the array. Find the smallest subsegment of the array which also has x as the maximum frequency element.
*/
import java.util.*;
public class smallestSubarrayWithAllOccurenceOfMFE {
    static class Pair{
        int n;
        int s;
        int e;
        Pair(int n, int s, int e){
            this.s = s;
            this.e = e;
            this.n = n;
        }
    }
    ArrayList<Integer> smallestSubsegment(int arr[], int n){
     HashMap<Integer, Pair> map = new HashMap<>();
     Pair p = new Pair(0, -1, -1);
     for(int i  = 0 ; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new Pair(1, i, i));
            } 
            else{
                Pair cp = map.get(arr[i]);
                cp.n += 1;
                cp.e = i;
            }
            Pair rp = map.get(arr[i]);
            if(rp.n > p.n){
                p = rp;
            }
            else if(rp.n == p.n){
                int nl = rp.e - rp.s + 1;
                int ol = p.e - p.s + 1;
                if(nl < ol){
                    p = rp;
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = p.s; i <= p.e; i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
