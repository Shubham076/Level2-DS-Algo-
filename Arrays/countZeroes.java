/*
Given a binary string S of size N, and a 2D array Q[][] of queries consisting of M pairs of the form {L, R}, the task for each query is to find the maximum number of 0s lying between two 1s in the range [L, R].
prefix sum
for ex 
*/
public class countZeroes {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1};
        int[] left = new int[arr.length]; //storing the no of zeroes to the right of nearest one
        int[] right = new int[arr.length];//storing the no of zeroes to the left of nearest one
        int total = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                total++;
            }
            else if(arr[i] == 1){
                cnt = total;
            }
            right[i] = cnt;
        }
        total = 0;
        cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                total++;
            }
            else if(arr[i] == 1){
                cnt = total;
            }
            left[i] = cnt;
        }
        for (int i : left) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : right) {
            System.out.print(i + " ");
        }
        System.out.println();
        int l = 2;
        int r = 7;
        System.out.println(Math.abs(left[l] + right[r] - total));
    }
}
