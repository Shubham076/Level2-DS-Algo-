// lintcode 508
public class wiggleSort {
    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void wiggle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if ((i & 1) == 0) {

                if (arr[i] <= arr[i + 1]) {
                    continue;
                } else {
                    swap(i, i + 1, arr);
                }
            } else {

                if (arr[i] >= arr[i + 1]) {
                    continue;
                } else {
                    swap(i, i + 1, arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1, 6, 4 };
        wiggle(arr);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}
