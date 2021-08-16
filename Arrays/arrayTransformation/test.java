import java.util.*;

public class test {
    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;

        while (low < high) {
            final int mid = (low + high) / 2;

            // Checks if the value is less
            // than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Function that returns the cost of making
    // all elements equal to current element
    public static int costCalculation(int current, int arr[], int n, int pref[], int a, int r, int minimum) {

        // Compute the lower bound
        // of current element
        int index = lowerBound(arr, arr.length, current);

        // Calculate the requirement
        // of add operation
        System.out.println("prefix of index: " + pref[index]);
        int left = index * current - pref[index];

        // Calculate the requirement
        // of subtract operation
        int right = pref[n] - pref[index] - (n - index) * current;

        System.out.println(left + " " + right + " " + index + " " + current);
        // Compute minimum of left and right
        int res = Math.min(left, right);
        left -= res;
        right -= res;

        // Computing the total cost of add
        // and subtract operations
        int total = res * minimum;
        total += left * a;
        total += right * r;

        return total;
    }

    // Function that prints minimum cost
    // of making all elements equal
    public static void solve(int arr[], int n, int a, int r, int m) {

        // Sort the given array
        Arrays.sort(arr);

        // Calculate minimum from a + r and m
        int minimum = Math.min(a + r, m);

        int[] pref = new int[n + 1];
        Arrays.fill(pref, 0);

        // Compute prefix sum and
        // store in pref array
        for (int i = 0; i < n; i++)
            pref[i + 1] = pref[i] + arr[i];

        int ans = 10000;

        // Find the minimum cost
        // from the given elemen
        // Finding the minimum cost
        // from the other cases where
        // minimum cost can occur
        ans = Math.min(ans, costCalculation(pref[n] / n, arr, n, pref, a, r, minimum));

        // Printing the minimum cost of making
        // all elements equal
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2 };
        int A = 2, R = 4, M = 5;
        int size = arr.length;

        // Function Call
        solve(arr, size, A, R, M);
    }
}
