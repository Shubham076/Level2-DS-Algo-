/*
if rem == 0 it is a z.
	but why -1 ?? let say n = 26 => by doing n = n / 26 we get n = 1; but we know that answer if
	Z after that is should come out of the loop so we decrement it by 1
if rem != 0 
	we know the ascii value of A is 65
	how to get 65 when rem  == 1  =>  rem - 1 + 65
*/
class excelColumnNameFromNumber{
	public static void main(String[] args){
		int n = 52;
		String ans = "";
		while(n > 0){
			int r = n % 26;

			if(r == 0){
				ans = 'Z' + ans;
				n = n / 26 - 1;
			}
			else{
				ans = (char)(r - 1 + 65) + ans;
				n /= 26;
			}
		}
		System.out.println(ans);
	}
}