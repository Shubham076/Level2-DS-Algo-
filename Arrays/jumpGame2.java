/**
 * jumpGame2
 */
public class jumpGame2 {

    public static void main(String[] args) {
        
        int[] arr = {1,1,1,1,1,1};
       System.out.println(minSteps(arr)); 
    }

    // explanation is there on geeks for geeks

    public static int minSteps(int[] nums){

        int maxReach = nums[0];
        int jump =1;
        int steps = nums[0];

        for(int i = 1 ; i < nums.length ; i++){

            if( i == nums.length -1) return jump;

            maxReach = Math.max(maxReach, i + nums[i]);

            steps--;

            if(steps == 0){

                jump++;

                if( i >= maxReach){
                    return  -1;
                }

                steps = maxReach -i;


            }
        }

        return -1;
    }
}