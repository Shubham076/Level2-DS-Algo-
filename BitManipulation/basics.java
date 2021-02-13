import java.util.*;
class basics{
	//range of storage types -2^(n - 1) to 2^(n - 1) - 1
	// for eg int = 32 bit limit -2^31 to 2^31 - 1
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i = scn.nextInt();
		int j = scn.nextInt();
		int k = scn.nextInt();
		int l = scn.nextInt();
		int onMask = (1 << i);   /// create a mask like something 000100
		int offMask = ~(1 << j); /// create a mask like something 1110111
		int toggleMask = (1 << k); /// create a mask like something 000100
		int check = (1 << l); 

		System.out.println(n | onMask);
		System.out.println(n & offMask);
		System.out.println(n ^ toggleMask);
		System.out.println((n & check) == 0 ? false : true);


	}
}