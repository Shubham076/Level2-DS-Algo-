public class maxChunkstoMakeSorted2 {
    public static int maxChunksToSorted(int[] arr) {
        int ans = 1;
        int[] min = new int[arr.length];
        int[] max = new int[arr.length];
        
        min[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            min[i] = Math.min(arr[i], min[i + 1]);
        }
        max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max[i] = Math.max(arr[i], max[i - 1]);
        }

        for(int i = 0; i < arr.length - 1; i++){
            if(max[i] <= min[i + 1]) ans++;
        }

        return ans;
    }
    public static void main(String[] args){
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(maxChunksToSorted(nums));
    }
}
