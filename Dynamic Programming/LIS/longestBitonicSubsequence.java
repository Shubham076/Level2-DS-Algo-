import java.util.Scanner;
public class longestBitonicSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] lis = new int[n];
        int[] lds = new int[n];
        int omax = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        scn.close();
        // lis
        for (int i = 0; i < lis.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = 1 + max;
        }

        // lds
        for (int i = lds.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }
            lds[i] = 1 + max;
        }
        for (int i = 0; i < arr.length; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }
        System.out.println(omax);
    }
}
