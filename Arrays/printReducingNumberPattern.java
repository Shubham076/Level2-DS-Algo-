//leetcode greedy approach
import java.util.*;
public class printReducingNumberPattern {
    public static void innerPattern(int n)
    {   
        // Pattern Size
        int s = 2 * n;
        int a[][] = new int[s][s];
        int f = 0;
        int b = s - 1;
        String ans = "";
        while (n != 0) {
            for (int i = f; i <= b; i++) {
                for (int j = f; j <= b; j++) {
                    if (i == f || i == b || j == f || j == b){
                        a[i][j] = n;
                        ans += n;
                    } 
                }
            }
            f++;
            b--;
            n--;
        }
        print(a, s);
    }
  
    // function to Print pattern
    public static void print(int a[][], int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int n = 2;
        innerPattern(n);
    }
}
