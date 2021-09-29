//space O(1) and time = O(NlogN) where N = (n + m)
//logic explanation https://youtu.be/hVl2b3bLzBw striver (gap method)
public class merge2SortedArrays2 {
    static int gap(int n) {
        double v = Math.ceil(n / 2.0); 
        return (int)v;
    }

    static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swap(int i, int j, int[] a, int[] b) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    static void print(int[] arr1, int[] arr2){
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeAndSort(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int N = n + m;
        int i, j;
        for (int gap = gap(N); gap >= 1; gap = gap(N)) {
            // comparing with gap in first array
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]){
                    swap(i, i + gap, arr1);
                }
            }

            // comparing in both arrays
            for (j = i + gap - n; i < n && j < m; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    swap(i, j, arr1, arr2);
                }
            }

            if (j < m) {
                // comparing with gap in second array
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]){
                        swap(j, j + gap, arr2);
                    }
                    
                }
            }

            N /= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 4, 5};
        int[] arr2 = { 2, 3, 4 };
        mergeAndSort(arr1, arr2);
        print(arr1, arr2);
    }
}
