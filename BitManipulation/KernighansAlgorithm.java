import java.util.*;
class KernighansAlgorithm{
	// KernighansAlgorithm = count number of on bits 
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println("No is : " + Integer.toBinaryString(n));
		int count = 0;
		while(n != 0){
			int rsb = n & -n;
			n -= rsb;
			count++;
		}
		System.out.println("No of on bits : " + count);
	}
}