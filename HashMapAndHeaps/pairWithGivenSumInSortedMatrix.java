/*
https://www.geeksforgeeks.org/count-pairs-two-sorted-matrices-given-sum/
*/
import java.util.*;
class pairWithGivenSumInSortedMatrix{

    //O(n * m) space = o(n * m)
    static int method1(int[][] mat1, int[][] mat2, int val){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < mat2.length; i++){
            for(int j = 0; j < mat2[0].length; j++){
                set.add(mat2[i][j]);
            }
        }
        int cnt = 0;
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat1[0].length; j++){
                int rem = val - mat1[i][j];
                if(set.contains(rem)) cnt++; 
            }
        }
        return cnt;
    }

    static boolean search(int[][] arr, int x){
        int i = 0;
        int j = arr.length - 1; 
        while(i < arr.length && j >= 0){
            if(arr[i][j] == x){
                return true;
            }
            else if(arr[i][j] > x){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

    //O(n * n logn) o(1) space
    static int method2(int[][] mat1, int[][] mat2, int val){
        int cnt = 0;
        for(int i = 0; i < mat1.length; i++){
            for(int j = 0; j < mat1[0].length; j++){
                int rem = val - mat1[i][j];
                if(search(mat2, rem)) cnt++; 
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        int[][] mat1 = {{1, 5, 6}, {8, 10, 11}, {15, 16, 18}};
        int[][] mat2 = {{2, 4, 7}, {9, 10, 12}, {13, 16, 20}};
        int val = 21;
        int cnt1 = method1(mat1, mat2, val);
        int cnt2 = method2(mat1, mat2, val);
        System.out.println(cnt1 + " " + cnt2);
    }
}