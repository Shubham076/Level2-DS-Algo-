// using o(1) space O(n * m) time complexity
public class merge2SortedArrays {
    static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swap(int i, int j, int[] arr1, int[] arr2){
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[j] > arr[j + 1]){
                    swap(i, j, arr);
                }
                else break;
            }
        }
    }
    public static void sortAndMerge(int[] arr1, int[] arr2){
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] > arr2[0]){
        /*  since the both the arrays are sorted. All the element after ith index are greater
            than the element at the ith index;
            and if the element at ith idx is greater than jth index after swapping
            still the first array remains sorted but we have to sort second    
        */
                swap(i, 0, arr1, arr2);

                //moving arr2[0] to its actual position
                sort(arr2);
            }
        }
    }
    public static void main(String[] args){
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 4};
        sortAndMerge(arr1, arr2);
        for(int i: arr1){
            System.out.print(i + " ");
        }
        for(int i: arr2){
            System.out.print(i + " ");
        }
    }
}
