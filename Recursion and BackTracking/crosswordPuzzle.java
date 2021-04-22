import java.util.*;

public class crosswordPuzzle {

    public static void solution(char[][] arr, String[] words, int vidx) {
        //write your code here
        if ( vidx == words.length) {
            print(arr);
            return;
        }

        String word = words[vidx];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {

                    if (canPlaceHorizontally(arr , i , j , word)) {
                        boolean[] selfPlaced = placeWordHorizontally(arr , i , j , word);
                        solution(arr , words , vidx + 1);
                        removeWordHorizontally(arr , i , j , word , selfPlaced);
                    }

                    if (canPlaceVertically(arr , i , j , word)) {
                        boolean[] selfPlaced = placeWordVertically(arr , i , j , word);
                        solution(arr , words , vidx + 1);
                        removeWordVertically(arr , i , j , word , selfPlaced);
                    }
                }


            }
        }

    }

    public static boolean canPlaceHorizontally(char[][] arr , int i , int j , String word) {

        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        }

        else if ( j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }

        for (int col = 0; col < word.length(); col++) {
            if ( j + col >= arr[0].length) return false;

            if (arr[i][j + col] == '-' || arr[i][j + col] == word.charAt(col)) continue;
            else return false;
        }

        return true;
    }

    public static boolean canPlaceVertically(char[][] arr , int i , int j , String word) {

        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        }

        else if ( i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }

        for (int row = 0; row < word.length(); row++) {
            if ( i + row >= arr.length) return false;

            if (arr[i + row][j] == '-' || arr[i + row][j] == word.charAt(row)) continue;
            else return false;
        }

        return true;
    }

    public static boolean[] placeWordHorizontally(char[][] arr , int i , int j , String word) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int col = 0; col < word.length(); col++) {
            if (arr[i][j + col] == '-') {
                arr[i][j + col] = word.charAt(col);
                wePlaced[col] = true;
            }
        }

        return wePlaced;
    }

    public static boolean[] placeWordVertically(char[][] arr , int i , int j , String word) {
        boolean[] wePlaced = new boolean[word.length()];

        for (int row = 0; row < word.length(); row++) {
            if (arr[i + row ][j] == '-') {
                arr[i + row][j] = word.charAt(row);
                wePlaced[row] = true;
            }
        }

        return wePlaced;
    }

    public static void removeWordHorizontally(char[][] arr , int i , int j , String word , boolean[] wePlaced) {

        for (int col = 0; col < word.length(); col++) {
            if (wePlaced[col] == true) {
                arr[i][j + col] = '-';
            }
        }
    }

    public static void removeWordVertically(char[][] arr , int i , int j , String word , boolean[] wePlaced) {

        for (int row = 0; row < word.length(); row++) {
            if (wePlaced[row] == true) {
                arr[i + row][j] = '-';
            }
        }
    }

    public static void print(char[][] arr) {
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0 ; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0 ; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0 ; i  < words.length; i++) {
            words[i] = scn.next();
        }

        solution(arr , words , 0);
    }
}