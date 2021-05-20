class NQueenPermutations1{
	//queen chooses the box
	//qs queen selected tq = total queens
	public static void queensPermutations(int qs, int tq, int[][] chess){
        if(qs == tq){
        	for(int i = 0; i < tq; i++){
        		for(int j = 0; j < tq; j++){
        			if(chess[i][j] == 0){
        				System.out.print("-\t");
        			}
        			else{
        				System.out.print("q" + chess[i][j] + "\t");
        			}
        		}
        		System.out.println();
        	}
        	System.out.println();
        	return;
        }

        for(int i = 0; i < tq; i++){
        	for(int j = 0; j < tq; j++){
        		if(chess[i][j] == 0){
        			chess[i][j] = qs + 1;
        			queensPermutations(qs + 1, tq, chess);
        			chess[i][j] = 0;
        		}
        	}
        }
    }
	public static void main(String[] args){
		int n = 2;
		int[][] chess = new int[2][2];
		queensPermutations(0, 2, chess);
	}
}