//leetcode 1304
public class NUniqueIntegerSumUpto0 {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int j = 0;
        for(int i = 1; i <= n / 2; i++){
            arr[j] = i;
            arr[j + 1] = -i;
            j += 2;
        }
        if(n % 2 != 0)
            arr[n - 1] = 0;
        return arr;        
    }
}
