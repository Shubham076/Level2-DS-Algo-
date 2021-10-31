/*
O(n^2) time and O(1) space algorithm ( without any workarounds and hanky-panky stuff! )

*Rotate by +90:
Transpose
Reverse each row

*Rotate by -90:
Method 1 :
Transpose
Reverse each column

Method 2 :
Reverse each row
Transpose

*Rotate by +180:
Method 1: Rotate by +90 twice
Method 2: Reverse each row and then reverse each column (Transpose)

*Rotate by -180:
Method 1: Rotate by -90 twice
Method 2: Reverse each column and then reverse each row
Method 3: Rotate by +180 as they are same

*/
class rotateMatrix{
    static int[][] generate(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] narr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                narr[i][j] = arr[i][j];
            }
        }
        return narr;
    }

    static void print(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void transpose(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    static void rotate90(int[][] a){
        int[][] arr = generate(a);
        int n = arr.length;
        transpose(arr);
        for(int i = 0; i < n; i++){
            int l = 0;
            int r = arr[0].length - 1;
            while(l < r){
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;
            }
        }
        print(arr);
    }

    static void printNegative90(int[][] a){
        int[][] arr = generate(a);
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int l = 0;
            int r = arr[0].length - 1;
            while(l < r){
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;
            }
        }
        transpose(arr);
        print(arr);
    }
    public static void main(String[] args){
        int[][] arr = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};
        System.out.println("Original");
        print(arr);
        System.out.println("Rotate 90");
        rotate90(arr);
        System.out.println("Rotate -90");
        printNegative90(arr);
    }
}