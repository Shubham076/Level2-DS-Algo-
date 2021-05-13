import java.util.*;
//time complexity logn + k +  klogk
public class findKclosest2 {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(arr[mid] == x){
                break;
            }
            else if(arr[mid] > x){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        int l = mid - 1;
        int r = mid;
        while(l >= 0 && r < arr.length && k > 0){
            if(Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)){
                ans.add(arr[l]);
                l--;
            }
            else{
                ans.add(arr[r]);
                r++;
            }
            k--;
        }

        while(k > 0 && l >= 0){
            ans.add(arr[l]);
            l--;
            k--;
        }
        while(k > 0 && r < arr.length){
            ans.add(arr[r]);
            r++;
            k--;
        }

        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
		int k = 4, x = -1;
		System.out.println(findClosestElements(arr, k, x));
    }
}
