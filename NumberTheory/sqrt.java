class sqrt{
	public static double mySqrt(int n) {   
      if( n == 0 || n == 1) return n;
        double low = 0.0;
        double high = n;
        double ans = 0.0;
        double precision = Math.pow(10, -4);
        while(high - low > precision){
            double mid = low + (high - low) / 2.0;
            if( mid * mid <= n){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low + (high - low) / 2.0;
    }
	public static void main(String[] args) {
		int n = 4;
		System.out.println(mySqrt(n));
	}
}