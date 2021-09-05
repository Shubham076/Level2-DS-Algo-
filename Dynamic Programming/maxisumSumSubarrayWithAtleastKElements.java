//https://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/
public class maxisumSumSubarrayWithAtleastKElements {
    public static void main(String[] args){
        int[] arr = {1, 1, 1, 1, 1, 1};
        int[] maxSum = new int[arr.length];
        int k = 2;
        maxSum[0] = arr[0];
        int csum = arr[0];  //current sum

        //kadanes algo
        //calculating the max sum ending at ith index
        for(int i = 1; i < arr.length; i++){
            if(csum > 0){
                csum += arr[i];
            }
            else{
                csum = arr[i];
            }
            maxSum[i] = Math.max(csum, maxSum[i - 1]);
        }

        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        
        int ans = sum;
        /*concept of sliding window
         calculating the sum of each window and including the contribution maximum sum before that 
         window

        */
        for(int i = k; i < arr.length; i++){
            sum += arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum + maxSum[i - k]);
        }
        System.out.print(ans);
    }
}
