public class maxChunkstoMakeSorted {

    public static int maxChunksToSorted(int[] arr) {
        int ans = 1;
        int maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            maxIdx = Math.max(maxIdx, arr[i]);
            if (i == maxIdx) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 1, 0 };
        System.out.println(maxChunksToSorted(nums));
    }
}
