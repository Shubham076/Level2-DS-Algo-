/*
https://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/
approach is similar to something merging of two sorted arrays
O(n + m);
*/
import java.util.*;
public class maximumSumPathInTwoArrays {
    public static void main(String[] args){
        int[] arr1 = {2, 3, 7, 10, 12};
        int[] arr2 = {1, 5, 7, 8};
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        int ans = 0;
        int sum1 = 0, sum2 = 0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                sum1 += arr1[i++];
            }
            else if(arr1[i] > arr2[j]){
                sum2 += arr2[j++];
            }
            else{
                //adding the maximum sum upto common point in the answer
                ans += Math.max(sum1, sum2);

                //adding the common point
                ans += arr1[i];
                sum1 = sum2 = 0;

                i++;
                j++;
            }
        }

        while(i < n){
            sum1 += arr1[i++];
        }
        while(j < m){
            sum2 += arr2[j++];
        }

        // if no common point found taking the max of sum1 and sum2
        ans += Math.max(sum1, sum2);
        System.out.println(ans);
    }
}
