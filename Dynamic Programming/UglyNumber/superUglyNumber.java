/*
leetcode 313
*/
import java.util.*;
public class superUglyNumber {
    static class Pair implements Comparable<Pair>{
        int prime;
        int pointer;
        int val;
        Pair(int prime, int pointer, int val){
            this.prime = prime;
            this.pointer = pointer;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] dp = new int[n];
        for(int i = 0; i < primes.length; i++){
            q.add(new Pair(primes[i], 0, primes[i]));
        }        
        dp[0] = 1;
        int i = 1;
        while(i < n){
            //min
            Pair rm = q.remove();
            if(rm.val != dp[i - 1]){
                dp[i] = rm.val;
                i++;
            }
            rm.pointer++;
            if(rm.pointer < n){
                rm.val = rm.prime * dp[rm.pointer]; 
                q.add(rm);
            }
        }

        for(int v : dp){
            System.out.print(v + " ");
        }
        return dp[n - 1];
    }
    public static void main(String[] args){
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        nthSuperUglyNumber(n, primes);
    }
}
