class NQueenPermutation2{
	//box choses the queen
	//sq = selected queens, tq = total queens
	public static void queensPermutations(int sq, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
        	if(sq == tq){
        		System.out.println(asf);
        	}
        	return;
        }
        int nr = row;
        int nc = col;
        String sep = " ";

        if(col == tq - 1){
        	nr = row + 1;
        	nc = 0;
        	sep = "\n";
        }
        else{
        	nc = col + 1;
        	sep = " ";
        }

        for(int i = 0; i < queens.length; i++){
        	if(queens[i] == false){
        		queens[i] = true;
        		queensPermutations(sq + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens);
        		queens[i] = false;
        	}
        }
        //when box not chooses the queen
        queensPermutations(sq, tq, nr, nc, asf + "-" + sep, queens);
    }
	public static void main(String[] args){
		int n = 2;
		boolean[] queens = new boolean[n];
		queensPermutations(0, n, 0, 0, "", queens);
	}
}