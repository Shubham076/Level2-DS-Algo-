//operations
// N is even N / 2;
// N is odd N + 1 or N - 1

import java.util.*;
class ReduceNTo1{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		long n = N;
		int res = 0;
		while(n != 1){
			if(n % 2 == 0){
				n /= 2;
			}
			else if(n == 3){
				res += 2;
				break;
			}
			else if((n & 3) == 1){
				n = n -1;
			}
			else if((n & 3) == 3){
				n = n + 1;
			}
			res++;
		}

		System.out.println(res);
	}
}