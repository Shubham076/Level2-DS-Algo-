//search the cnt of occurences of word in the grid word can be found horizontally diagonally or vertical
public class searchWordin2dMatrix {
    static int[][] dirs = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int cnt;

    public static void search(char[][] arr, String word, int i, int j){
        int n = arr.length;
        int m = arr[0].length;
        if(arr[i][j] != word.charAt(0)) return;

        for(int[] d : dirs){
            int ni = i + d[0];
            int nj = j + d[1];
            int k;
            for(k = 1; k < word.length(); k++){
                if(ni < 0 || ni >= n || nj < 0 || nj >= m){
                    //if we are out of bounds break and check in different direction
                    break;
                }

                if(arr[ni][nj] != word.charAt(k)){
                    //break and check in different direction
                    break;
                }

                // move in that particular direction
                ni += d[0];
                nj += d[1];
            }

            //all the characters matched
            if(k == word.length()){
                // System.out.println(i + " " + j);
                cnt++;
            }
        }
    }
    public static void main(String[] args){
        char[][] arr = {{'g', 'o', 'g', 'o', 'g'},
                        {'o', 'o', 'o', 'o', 'o'},
                        {'g', 'o', 'd', 'o', 'g'},
                        {'o', 'o', 'o', 'o', 'o'},
                        {'g', 'o', 'g', 'o', 'g'}};
        int n = arr.length;
        int m = arr[0].length;
        String word = "dog";
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                search(arr, word, i, j);
            }
        }
        System.out.println(cnt);
    }
}
