// difficulty hard
//https://www.geeksforgeeks.org/minimum-cost-to-make-all-array-elements-equal-using-given-operations/?ref=rp
import java.util.*;
class minimumCostToMakeArrayElementsEqual2{
    public static int lowerBound(int[] arr, int val){
        int lo = 0;
        int hi = arr.length - 1;
        int ans = -1;
        int mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(arr[mid] == val){
                ans = mid;
                hi = mid - 1;
            }
            else if(arr[mid] > val){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        if(ans == -1){
            //means element not present in the array return the index of element closest to val
            return mid;
        }
        else{
            return ans;
        }
    }
    public static int cost(int cur, int[] arr, int[] pre, int a, int b, int min){
        //here we are making all the elements of array equal to current
        int n = arr.length;
        int idx = lowerBound(arr, cur);
        
        // Calculate the requirement of add operation
        int left = Math.abs(pre[idx] - (idx * cur));

        // Calculate the requirement of subtract operation
        int right = Math.abs(pre[n] - pre[idx] - (n - idx) * cur);

        //now we have the diff of left elements and right elements with the cur
        //ab hum dono ka min lenge kyu m wali condition mein left mein ek increse or right mein ek 
        //decrease krna hota ye condition tbhi lgegi jb cur ke left and right mein equal elemnts ho
        //min se ye pta chl jayega cur ke dono side kitne equal
        int res = Math.min(left, right);
        int total = 0;

        //total mein m wali cost
        total += res * min;
        left -= res;
        right -= res;

        //is step ke baad jo left ya right mein bche gye unke lie right ya left mein koi element nhi jis se pair krske  
        total += left * a;
        total += right * b;
        
        return total;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        Arrays.sort(arr);
        int n = arr.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++){
            pre[i + 1] = pre[i] + arr[i];
        }
        int a = 1;
        int b = 1;
        int m = 1;
        // find the minimum of the M and A + B as M can make both operations simultaneously.
        int min = Math.min(a + b, m);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            ans = Math.min(ans, cost(arr[i], arr, pre, a, b, min));
        }
        int median = n % 2 == 0 ? (arr[n / 2] + arr[n / 2 - 1]) / 2 : arr[n / 2];
        ans = Math.min(ans, cost(median, arr, pre, a, b, min));
        System.out.println(ans);   
    }
}