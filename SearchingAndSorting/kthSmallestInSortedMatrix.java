///leetcode 378
public class kthSmallestInSortedMatrix {
    /* Algo:
    here we have to find the kth smallest number in the matrix that is row and col wise sorted
    as matrix is sorted we can use binary search to solve this problem
    1: first cal lo and hi first => first and last element in the matrix
    2: now we calculate value of mid. mid is false value not necessarily present in the matrix
    now with the help of mid we find no of el in the matrix <= mid

    if the count of el => k then our answer is the max of all the nos
    count > k means we have to reduce the range hi => mid
    count < k means we have to increase the range

    why this approach works if we have k elements in the sorted array and we have to find the
    kth smallest element then answer is the last el of array

    thats why by cal mid we are counting the nos lie in the range <= mid
    the moment we have cnt == k means we have find the answer

    O(2n * log(max - min) O(1) space
    */
     public static int kthSmallest(int[][] arr, int k) {
         int n = arr.length - 1;
         int m = arr[0].length - 1;
         int lo = arr[0][0];
         int hi = arr[n][m];
         while(lo < hi){
                /*
                we can easily cnt elements in o(n) time
                we are starting from the top right corner of matrix
                if the el is greater than mid then all the el in the col are also greater
                we can simply reduce j = j - 1;
                if el is <= mid means all the elements in the row are in the range
                we increase i by 1 and cnt += (j + 1) elements
                */
                int mid = lo + (hi - lo) / 2;
                int i = 0, j = m;
                int count = 0;

             //o(2*n) in worst case as we are moving in form of staircase
             while(j >= 0 && i <= n) {
                 while (j >= 0 && arr[i][j] > mid) j--;


                 //updating ans with max of each valid row
                 count += (j + 1);
                 i++;
             }
             //now counting is complete
             if(count >= k){
                 hi = mid;
             }
             else{
                 lo = mid + 1;
             }
          }
         return lo;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        System.out.println(kthSmallest(arr, k));
    }
}
