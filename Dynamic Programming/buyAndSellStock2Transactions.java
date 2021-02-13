import java.util.Scanner;

class buyAndSellStock2Transactions{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();

        int mpl = 0;
        int[] dpl = new int[n];
        int lsf = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < lsf){
                lsf = arr[i];
            }

            mpl = arr[i] - lsf;
            if(mpl > dpl[i - 1]){
                dpl[i] = mpl;
            }
            else{
                dpl[i] = dpl[i - 1];
            }
        }

        int mpr = 0;
        int msf = arr[n - 1];
        int[] dpr = new int[n];
        for(int i = arr.length -2; i >= 0; i--){
            if(arr[i] > msf){
                msf = arr[i];
            }

            mpr = msf - arr[i] ;
            if(mpr > dpr[i + 1]){
                dpr[i] = mpr;
            }
            else{
                dpr[i] = dpr[i + 1];
            }


        }

        int op = 0;
        for(int i = 0; i < arr.length; i++){
            if(dpl[i] + dpr[i] > op){
                op = dpl[i] + dpr[i];
            }
        }

        System.out.println(op);

    }
}