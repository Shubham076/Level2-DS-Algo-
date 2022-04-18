/*

leetcode 1385
*/
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int c = arr1.length;
        
        for(int v: arr1) {
            int lo = 0, hi = arr2.length - 1;
            
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                
                if(arr2[mid] >= v - d && arr2[mid] <= v + d){
                    c--;
                    break;
                }
                else if(arr2[mid] < v - d) {
                    lo = mid + 1;
                }
                else{
                    hi = mid - 1;
                }
            }
        }
        return c;
    }
}