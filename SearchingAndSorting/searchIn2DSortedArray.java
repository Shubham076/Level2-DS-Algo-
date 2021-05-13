//leetcode 74
public class searchIn2DSortedArray {
    public static int binarySearchforRow(int[][] arr, int v){
        int lo = 0;
        int hi = arr.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(arr[mid][0] <= v && arr[mid][arr[0].length - 1] >= v){
                return mid;
            }
            else if(arr[mid][0] < v){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }

        return -1;
    }

    public static boolean find(int[][] arr, int v){
        int row = binarySearchforRow(arr, v);
        if(row == -1) return false;
        else{
            int lo = 0;
            int hi = arr[0].length - 1;
            while(lo <= hi){
                int mid = (lo + hi) / 2;
                if(arr[row][mid] == v) return true;
                else if(arr[row][mid] < v) lo = mid + 1;
                else hi = mid - 1;
            }

            return false;
        }
    }
    public static void main(String[] args){
        int[][] arr = {{11,12,13,14,15} , 
                        {21,22,23,24,25} ,
                        {31,32,33,34,35} , 
                        {41,42,43,44,45}};

        System.out.println(find(arr, 20));
    }
}
