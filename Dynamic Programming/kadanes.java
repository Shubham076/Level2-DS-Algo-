public class kadanes {
    public static void main(String[] args){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int curMax = arr[0];
        int omax = arr[0]; //overall max

        for(int i = 1; i < arr.length; i++){
            if(curMax >= 0){
                curMax += arr[i];
            }
            else curMax = arr[i];

            if(curMax > omax){
                omax = curMax;
            }

        }
        System.out.println(omax);
    }
}
