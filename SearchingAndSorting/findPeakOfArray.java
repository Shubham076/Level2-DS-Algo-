/*
leetcode 162
https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
eg = {10, 20, 15, 2, 23, 90, 67}
output = 20 or 90
if mid > mid + 1 means peak lies in the left;
otherwise right
*/
public class findPeakOfArray {

    //el that is greater than left and right elements
    static int peak(int[] arr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return arr[l];
    }

    //el that is smaller than left and right elements
    static int localMin(int[] arr, int n) {
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return arr[l];
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 15, 2, 23, 90, 67};
        int n = arr.length;
        System.out.println(peak(arr, n));
        System.out.println(localMin(arr, n));
    }
}
