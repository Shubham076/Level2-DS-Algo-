// variation
// on the end of every ride an uber driver gets a rating.The value of driver is computed 
// by taking the average of the rating * minimum rating in that period
// ed rating = [1,2,3,4] value = (1 + 2 + 3 + 4) / 1 = 9
// your task is to calculate the maximum value over any contiguous period driver days in uber
// Given driver average ratings
// eg arr = [3, 1, 6, 5, 4, 2]; ans = (6 + 5 + 4) * 4 = 60  


class kadanesVariation{
    public static void main(String[] args){
        int[] arr = {3, 1, 6, 5, 4, 2};
        long sum = arr[0];
        int min = arr[0];
        long oans = arr[0] * arr[0], ans = arr[0] * arr[0]; //oans = overall ans

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            sum += arr[i];
            long exc = arr[i] * arr[i];
            long inc = sum * min;
            if(inc > exc){
                ans = inc;
            }
            else{
                ans = exc;
                min = arr[i];
                sum = arr[i];
            }
            if(ans > oans){
                oans = ans;
            }

        }
        System.out.println(oans);
    }
}