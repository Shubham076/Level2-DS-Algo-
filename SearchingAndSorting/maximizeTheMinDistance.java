
/*
https://www.geeksforgeeks.org/place-k-elements-such-that-minimum-distance-is-maximized/
problem:

Given an array representing n positions along a straight line. Find k (where k <= n) elements from the
array such that the minimum distance between any two (consecutive points among the k points) is maximized.


bruteforce generate all subsets of size k calculate max distance distance 
An Efficient Solution is based on Binary Search. We first sort the array.
Now we know maximum possible value result is arr[n-1] – arr[0] (for k = 2).
 
We do a binary search for maximum result for given k. We start with the middle of
the maximum possible result. If the middle is a feasible solution, we search on the right half of mid.
Else we search is left half. To check feasibility, we place k elements under given mid-distance.
O(NLogN) O(1) space
*/
import java.util.*;

class maximizeTheMinimumDistance {
    /* Returns true if it is possible to
       arrange k elements of arr[0..n-1]
       with minimum distance given as mid.
    */
    static boolean isFeasible(int mid, int arr[], int n, int k) {
        // Place first element at arr[0] position
        int pos = arr[0];

        // Initialize count of elements placed.
        int elements = 1;

        // Try placing k elements with minimum distance mid.
        for (int i = 1; i < n; i++) {
            if (arr[i] - pos >= mid) {
                // Place next element if its distance from the previously
                // placed element is greater than current mid
                pos = arr[i];
                elements++;

                if (elements == k)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 4, 9 };
        int k = 3;
        int n = arr.length;
        Arrays.sort(arr);

        // min and max distance possible
        int lo = 1, hi = arr[n - 1];
        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isFeasible(mid, arr, n, k)) {
                //collect the possible ans and try for other as we have to maximize
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}