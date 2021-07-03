//leetcode 633
class sumOfSquareNumbers{
	// O(C)	
	public static boolean judgeSquareSum(int c) {
        for(int i = 0; i * i <= c; i++){
        	for(int j = 0; j * j <= c; j++){
        		if(i * i + j * j == c){
        			return true;
        		}
        	}
        }
        return false;
    }

    // O(c ^ 1/2 * log c)
     public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
	public static void main(String[] args) {
		int c = 5;
		System.out.println(judgeSquareSum(c));
	}
}