//Time complexity O(NloglogN) use only when constrains <= 10^7
class seiveEratosthenes{
    public static void main(String[] args){
        int n = 10000;
        int count = 0;
        int[] arr = new int[n + 1];

        for(int i = 3; i <= n; i += 2){
            arr[i] = 1;
        }

        for(int i = 3; i * i <= n; i += 2){
            if(arr[i] == 1){
                for(long j = i * i; j <= n; j += i){
                    arr[(int)j] = 0;
                }
            }
        }

        arr[0] = arr[1] = 0;
        arr[2] = 1;
        for(int i = 0; i <= n; i++){
            if(arr[i] != 0) count++;
        }

        System.out.println(count);
    }
}