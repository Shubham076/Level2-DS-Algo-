//leetcode 1031
class maxSumOf2nonOverlappingSubarrays{

    //beginner friendly
    public static int maxSumTwoNoOverlap(int[] arr, int l, int m) {
        int ans = 0;
        int n = arr.length;
        int[] pmax = new int[n];  //ith index stores the maximum sum of sub-array of length m  from 0 to ith(inclusive == prefix max)
        int[] smax = new int[n];  //ith index stores the max of sum of sub-array of length m  from n - 1 to ith(inclusive == suffix max)
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        pmax[m - 1] = sum;
        for (int i = m; i < n; i++) {
            sum += arr[i] - arr[i - m];
            pmax[i] = Math.max(pmax[i - 1], sum);
        }

        sum = 0;
        for (int i = n - 1; i >= n - m; i--) {
            sum += arr[i];
        }
        smax[n - m] = sum;
        for (int i = n - m - 1; i >= 0; i--) {
            sum += arr[i] - arr[i + m];
            smax[i] = Math.max(smax[i + 1], sum);
        }

        //bounds for second array
        int lsum = 0;
        for (int i = 0; i < l - 1; i++) {
            lsum += arr[i];
        }

        int j = 0;
        for (int i = l - 1; i < n; i++) {
            lsum += arr[i];
            int left = (j >= 1 ? pmax[j - 1] : 0);
            int right = (i < n - 1 ? smax[i + 1] : 0);
            int msum = Math.max(left, right);
            int total = lsum + msum;
            ans = Math.max(ans, total);
            lsum -= arr[j++];
        }

        return ans;
    }
}