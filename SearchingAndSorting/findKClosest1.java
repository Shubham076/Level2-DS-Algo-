//leetcode 658
import java.util.*;
public class findKClosest1 {
    // Time complexity O(n) + klogk
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int v: arr){
            if(list.size() < k){
                list.add(v);
                
            }
            else{
                if(Math.abs(list.peekFirst() - x) > Math.abs(v - x)){
                    list.removeFirst();
                    list.add(v);
                }   
            }
        }
        
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
		int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
		int k = 3, x = 5;
		System.out.println(findClosestElements(arr, k, x));
	}
}
