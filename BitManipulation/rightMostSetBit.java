import java.util.Scanner;
class rightMostSetBit{
	//-n is the twos compliment of the n
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println("Number in binary " + Integer.toBinaryString(n));
		System.out.println("RSB is " + Integer.toBinaryString(n & -n));	
	}
}