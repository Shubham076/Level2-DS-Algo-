import java.util.*;
class JosephusProblem {
	
	public static int powerOf2(int n){
		int i = 1;
		while(i * 2 <= n){
			i = i * 2;
		}
		return i;
	}

	// calculate powerof2 alternate O(1)
	public static int power(int n){
		return (int)(Math.log(n) / Math.log(2));
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int minPow = powerOf2(n);
		int l = n - minPow;
		int ans = 2 * l + 1;
		System.out.println(ans);

	}
}