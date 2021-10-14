/*
Given a sorted array in which each element is repeated twice except one element
whose frequency is thrice. Find the element whose frequency is thrice. Expected time complexity O(logn) and space O(1)
input [4,4,5,5,5,6,6,7,7,8,8] output = 5
*/
class findElementInSortedArray {
    static int binarySearch(int arr[], int n) {
        // if array is even size that is not possible as it is given in ques all
        // elements apeear twice except once
        // if size is even means 2 elements appear have a req of one
        if (n % 2 == 0) {
            return -1;
        }
        if (n == 3) {
            return arr[0];
        }
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            return arr[0];
        }
        if (arr[n - 1] == arr[n - 2] && arr[n - 2] == arr[n - 3]) {
            return arr[n - 1];
        }

        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == arr[mid - 1] && arr[mid] == arr[mid + 1]) {
                return arr[mid];
            } 
            else if (arr[mid] == arr[mid - 1]) {
                int lc = mid - lo + 1;
                if (lc % 2 == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } 
            else if (arr[mid] == arr[mid + 1]) {
                int rc = hi - mid + 1;
                if (rc % 2 == 0) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 4, 5, 5, 5, 6, 6, 7, 7, 8, 8 };
        for (int i = 0; i < arr.length - 2; i += 2) {
            if (arr[i] == arr[i + 2]) {
                System.out.println("Linear: " + arr[i]);
            }
        }

        int el = binarySearch(arr, arr.length);
        System.out.println("Binary: " + el);
    }
}