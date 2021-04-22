class knightsProbability{
	static int[][] moves = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
	public static boolean isValid(int i, int j, int n){
		if(i < 0 || j < 0 || i >= n || j >= n) return false;
		else return true;
	} 
	public static double knightProbability(int n, int k, int r, int c) {
        double[][] cur = new double[n][n];
        double[][] next = new double[n][n];
        double ans = 0;
        cur[r][c] = 1;
        for(int m = 1; m <= k; m++){
        	for(int i = 0; i < n; i++){
        		for(int j = 0; j < n; j++){
        			int ni = 0, nj = 0;
        			for(int[] mv : moves){
        				ni = i + mv[0];
        				nj = j + mv[1];
        				if(isValid(ni, nj, n)){
        					next[ni][nj] += cur[i][j] / 8.0;
        				}
        			}
        		}
        	}
        	cur = next;
        	next = new double[n][n];
        }

        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		ans += cur[i][j];
        	}
        }
        return ans;
    }
	public static void main(String[] args){
		int n = 3, k = 2, r = 0, c = 0;
		System.out.println(knightProbability(n, k, r, c));
	}
}