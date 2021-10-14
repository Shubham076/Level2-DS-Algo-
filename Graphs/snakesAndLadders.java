//leetcode 909
import java.util.*;
public class snakesAndLadders {
    int bfs(ArrayList<Integer> list){
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        int d = list.size() - 1;
        q.add(0);
        visited.add(0);

        while(q.size() > 0){
            int s = q.size();
            while(s-- > 0){
                int rm = q.remove();

                if(rm == d){
                    return cnt;
                }

                //six moves of the dice
                for(int i = 1; i <= 6; i++){
                    int ni = rm + i;

                    //if we are out of board
                    if(ni > d){
                        break;
                    }

                    if(list.get(ni) != -1){
                        //means a ladder or snake
                        ni = list.get(ni) - 1;
                    }

                    if(!visited.contains(ni)){
                        q.add(ni);
                        visited.add(ni);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public int snakesAndLadders(int[][] board) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean left = true;
        for(int i = board.length - 1; i >= 0; i--){
            if(!left){
                for(int j = board[0].length - 1; j >= 0; j--){
                    list.add(board[i][j]);
                }
            }
            else{
                for(int j = 0; j < board[0].length; j++){
                    list.add(board[i][j]);
                }
            }
            left = !left;
        }
        return bfs(list);
    }
}
