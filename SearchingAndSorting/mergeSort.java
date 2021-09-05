//inplace merge sort O(nlogn) o(n) space
public class mergeSort {
    public static void merge(int[] arr, int lo, int hi, int mid){
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] a = new int[n1];
        int[] b = new int[n2];
        for(int i = 0; i < n1; i++){
            a[i] = arr[lo + i];
        }

        for(int i = 0; i < n2; i++){
            b[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = lo;
        while(i < n1 && j < n2){
            if(a[i] <= b[j]){
                arr[k] = a[i];
                i++;
                k++;
            }
            else{
                arr[k] = b[j];
                j++;
                k++;
            }
        }

        while(i < n1){
            arr[k] = a[i];
            i++;
            k++;
        }

        while(j < n2){
            arr[k] = b[j];
            j++;
            k++;
        }
    }
    public static void sort(int[] arr, int lo, int hi){
        if(lo == hi){
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, hi, mid);
    }
    public static void main(String[] args){
        int[] arr = {5, 10, 3, 6, 1};
        sort(arr, 0, arr.length - 1);
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
}
