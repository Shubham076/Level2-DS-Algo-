import java.util.*;
import java.io.*;
public class segmentedSieve {
    //assuming that the range between (n - m) is <= 100000 and this will work for m = 0 to n = 10^9 
    static int[] primes = new int[100005];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        calculatePrimes();
        Scanner scn = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = scn.nextInt();
        while(t-- > 0){
            int m  = scn.nextInt();
            int n  = scn.nextInt();
            int[] segment = new int[n - m + 1];
            for(int x : list){

                //checking if the current is out of bounds or not
                if(x * x > n){
                    break;
                }
                int start = (int)Math.ceil((m * 1.0 )/ x) * x;

                //if x is present in range we will check its multiple
                if(x >= m && x <= n) start = x + x;
                for(int j = start; j <= n; j += x){
                    segment[j - m] = 1;  //making not prime
                }
            }

            for(int i = m; i <= n; i++){
                if(segment[i - m] == 0 && i != 1){
                    out.println(i);
                }
            }
            out.println();
        }
        out.close();
    }

    public static void calculatePrimes(){
        //marking all odd nos prime
        for(int i = 3; i <= 100000; i = i + 2){
            primes[i] = 1;
        }

        for(int i = 3; i * i <= 100000; i += 2){
            if(primes[i] == 1){
                for(long j = i * i; j <= 100000; j += i){
                    primes[(int)j] = 0;  //marking all multiples not prime
                }
            }
        }

        primes[2] = 1;

        for(int i = 0; i <= 100000; i++){
            if(primes[i] != 0) list.add(i);
        }
    }
}
