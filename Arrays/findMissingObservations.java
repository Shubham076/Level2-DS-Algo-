//leetcode 2028
class findMissingObservations{
    public static int[] missingRolls(int[] arr, int m, int k) {
        int[] ans = new int[k];
        int sum = 0;
        for(int v: arr) sum += v;
        int rem = (m * (k + arr.length) - sum);
        if(rem > 6 * k || rem < k) return new int[0];
        int avg = rem / k; int offset = rem % k;
        
        int i = 0;
        while(i < k){
            ans[i] = avg + (offset > 0 ? 1 : 0);
            offset--;
            i++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {3, 2, 4, 3};
        int m = 4;
        int k = 2;
        int[] ans = missingRolls(arr, m, k);
        for(int v: ans){
            System.out.print(v + " ");
        }
    }
}