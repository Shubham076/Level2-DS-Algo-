import java.util.*;

public class lecicographicalOrder {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		scn.close();
		
		for( int i = 1; i <= 9 ; i++){
		    
		    printFamily(i , n);
		}

		//write your code here
	}
	
	public static void printFamily(int  i  , int  n){
	    
	    if( i > n) return;
	    
	    System.out.println(i);
	    
	    for(int j = 0; j < 10 ; j++){
	        
	        printFamily( i * 10 + j , n);
	    }
	}
	
}