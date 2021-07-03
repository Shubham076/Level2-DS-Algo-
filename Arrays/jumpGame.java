public class jumpGame {
    
    public static void main(String[] args) {
        
        int[] arr = {3,2,1,0,4};
        System.out.println(canReach(arr));
    }

    public static boolean canReach(int[] nums){

        int lastGoodIndex = nums.length -1;

        for(int i = nums.length-1 ; i>=0 ; i--){

            if( i+ nums[i] >= lastGoodIndex){

                lastGoodIndex = i;
            }


        }

        return lastGoodIndex == 0;
    }
}