/*
[0, 1, 2]
[3, 4, 5]

leetcode 
simply apply bfs and check all the possiblities of swapping
O(6!)
*/
import java.util.*;
class slidingPuzzle{
	public static int slidingPuzzle(int[][] board) {
        int[][] dirs = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {3, 1, 5}, {2, 4}};  //the positions we can swap with if 0 is present at ith index
        StringBuilder src = new StringBuilder("");
        StringBuilder des = new StringBuilder("123450");
        for(int i = 0; i < board.length; i++){
        	for(int j = 0; j < board[0].length; j++){
        		src.append(board[i][j]);
        	}
        }

        Queue<StringBuilder> q = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        q.add(src);
        set.add(src.toString());
        int level = 0;
        while(q.size() > 0){
        	int s = q.size();
        	while(s-- > 0){
        		StringBuilder rm = q.remove();
        		if(rm.toString().equals(des.toString())){
        			return level;
        		}

        		int idx = -1;
        		for(int i = 0; i < rm.length(); i++){
        			if(rm.charAt(i) == '0'){
        				idx = i;
        				break;
        			}
        		}

        		for(int i : dirs[idx]){
        			StringBuilder temp = new StringBuilder(rm);
        			char c = temp.charAt(i);
        			temp.setCharAt(i, '0');
        			temp.setCharAt(idx, c);

        			if(!set.contains(temp.toString())){
        				set.add(temp.toString());
        				q.add(temp);
        			}
        		}
        	}
        	level++;
        }
        return -1;
    }
	public static void main(String[] args) {
		int[][] board = {{4, 1, 2}, {5, 0, 3}};
		System.out.println(slidingPuzzle(board));
	}
}