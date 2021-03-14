import java.util.*;

// basic maths about operators
//ltc = left true count  lfc = left false count, rtc = right true count 
// expression is in the form  => left operator right 
//                            true                                false
// l & r                      ltc * rtc                           ltc * rfc + lfc * rtc + lfc * rfc
// l | r                      ltc * rfc + lfc * rtc + ltc * rtc   lfc * rfc
//l ^ r                       ltc * rfc + lfc * rtc               ltc * rtc + lfc * rfc
class booleanParenthesization{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		int n = s.length();
		String opt = scn.nextLine();

		// represents true count of left and right split
		int[][] True = new int[n][n];

		// represents false count of left and right split
		int[][] False = new int[n][n];

		for(int g = 0; g < n; g++){
			for(int i = 0, j = g; j < n; j++, i++){
				if(g == 0){
					char c = s.charAt(i);
					if(c == 'T'){
						True[i][j] = 1;
						False[i][j] = 0;
					}
					else{
						True[i][j] = 0;
						False[i][j] = 1;
					}
				}
				else{
					for(int k = i; k < j; k++){
						char op = opt.charAt(k);
						int ltc = True[i][k];
						int rtc = True[k + 1][j];
						int lfc = False[i][k];
						int rfc = False[k + 1][j];

						if(op == '|'){
							True[i][j] +=  ltc * rfc + lfc * rtc + ltc * rtc;
							False[i][j] += lfc * rfc;
						}
						else if(op == '&'){
							True[i][j] += ltc * rtc;
							False[i][j] += ltc * rfc + lfc * rtc + lfc * rfc;
						}
						else{
							True[i][j] += ltc * rfc + lfc * rtc;
							False[i][j] += ltc * rtc + lfc * rfc;
						}
					}
					
				}
			}
		}
		System.out.println(True[0][n - 1]);
	}
}