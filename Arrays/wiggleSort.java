/* lintcode 508
. Reorder it in-place such that :  arr[0] <= arr[1] >= arr[2] <= arr[3] . . . .
3. Please sort the array in place and do not define additional arrays.
*/
public class wiggleSort {
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void wiggle(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if ((i & 1) == 0) {  //even

				if (arr[i] > arr[i + 1]) {
					swap(i, i + 1, arr);
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					swap(i, i + 1, arr);
				} 
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 1, 6, 4};
		wiggle(arr);
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
