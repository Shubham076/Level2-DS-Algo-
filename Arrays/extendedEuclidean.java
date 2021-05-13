//find the value of x and y if eq is Ax + By = gcd(A , B); 
class extendedEuclidean{
	static int x;
	static int y;
	static int GCD;
	public static void main(String[] args){
		x = 0; y = 0; GCD = 0;
		//18x + 30y = 6;
		solve(18, 30);
		System.out.println(x + "," + y);
	}

	public static void solve(int a, int b){
		if(b == 0){
			x = 1;
			y = 0;
			GCD = a;
			return;
		}
		solve(b, a % b);
		int cx = y;
		int cy = x - (a / b) * y;
		x = cx;
		y = cy;
	}
}