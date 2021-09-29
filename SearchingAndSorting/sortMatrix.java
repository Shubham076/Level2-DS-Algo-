/*
leetcode 1329
O(n * m * log(x)) x = min(n, m)
*/
import java.util.*;
class sortMatrix {
    public static void diagonalSort(int[][] arr) {
        System.out.println("Before sorting");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        HashMap<Integer, PriorityQueue<Integer>> m = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int diff = i - j;
                m.putIfAbsent(diff, new PriorityQueue<>());
                m.get(diff).add(arr[i][j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int diff = i - j;
                arr[i][j] = m.get(diff).remove();
            }
        }
        System.out.println("After sorting");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = { { 11, 25, 66, 1, 69, 7 }, { 23, 55, 17, 45, 15, 52 }, { 75, 31, 36, 44, 58, 8 },
                { 22, 27, 33, 25, 68, 4 }, { 84, 28, 14, 11, 5, 50 } };
        diagonalSort(arr);
    }
}