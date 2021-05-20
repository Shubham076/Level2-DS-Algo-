class NQueenCombinations1 {
	public static void queensCombinations(int qs, int tq, boolean[][] chess, int lc) { //lc = last cell
		// write your code here
		if (qs == tq) {
			for (int i = 0; i < tq; i++) {
				for (int j = 0; j < tq; j++) {
					if (chess[i][j] == false) {
						System.out.print("-\t");
					} else {
						System.out.print("q" + "\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int cell = lc + 1; cell < chess.length * chess.length; cell++) {
			int i = cell / chess.length;
			int j = cell % chess.length;
			chess[i][j] = true;
			queensCombinations(qs + 1, tq, chess, cell);
			chess[i][j] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		int n = 2;
		boolean[][] chess = new boolean[n][n];
		queensCombinations(0, n, chess, -1);
	}
}