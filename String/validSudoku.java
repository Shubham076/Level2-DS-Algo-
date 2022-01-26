//leetcode 36
import java.util.*;
class validSudoku {
	//hashset return false if element is already present in the set
	public boolean isValid(char[][] board) {
		HashSet<String> seen = new HashSet();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char n = board[i][j];
				if (n != '.'){
					String block = (i / 3 * 3) + "-" + (j / 3 * 3);
					if(!seen.add(n + "in row" + i) || !seen.add(n + "in col" + j) ||
					 !seen.add(n + "in block" + block)){
						return false;
					}
				}
			}
		}
		return true;
	}
}