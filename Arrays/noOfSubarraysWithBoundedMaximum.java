//leetcode 795
//intuition let us assume we know the number of valid subarrays upto i - 1 elements or prevValid
//now when the ith element is added to the prevValid, we have to found how many more valid subarrays we have found
//3 cases are possible
//case 1 ith elements l <= ith <= r  => all the subarrays are valid after including this number

//case 2 ith < L we travel backwards and found the first number that is in the range L-R and
    // no of valid subarrays = no of valid subarrays made the first number that is in the range when we travel backwards

// case 3 ith > R we will split the array in left and right about ith number coz all the subarrays including ith numbaer are not valid
    // no of valid subarrays  = sum of (no of valid subarrays of left and right partition)
public class noOfSubarraysWithBoundedMaximum {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0;
        int i = 0;
        int prevValid = 0;
        for (int j = 0; j < A.length; j++) {
            if (A[j] >= L && A[j] <= R) {
                ans += j - i  + 1;
                prevValid = j - i  + 1;
            } else if (A[j] < L) {
                ans += prevValid;
            } else {
                i = j + 1;
                prevValid = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3};
        int l = 2;
        int r = 3;
        System.out.println(numSubarrayBoundedMax(arr, l , r));
    }
}
