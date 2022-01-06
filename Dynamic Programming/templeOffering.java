/*
https://www.geeksforgeeks.org/temple-offerings/

Q: Consider a devotee wishing to give offerings to temples along with a mountain range. 
The temples are located in a row at different heights. Each temple should receive at least one offer. 
If two adjacent temples are at different altitudes, then the temple that is higher up should receive more 
offerings than the one that is lower down. If two adjacent temples are at the same height, then their offerings
 relative to each other do not matter. Given the number of temples and the heights of the temples in order,
  find the minimum number of offerings to bring.

*/
public class templeOffering {
    public static void main(String[] args){
        int[] arr = {1, 4, 3, 6, 2, 1};
        int n = arr.length;
        int ans = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i - 1]){
                left[i] = left[i - 1] + 1;
            }
            else{
                left[i] = 1;
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(arr[i] > arr[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            else{
                right[i] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            int cmax = Math.max(left[i], right[i]);
            ans += cmax;
        }
        System.out.println(ans);
    }
}
