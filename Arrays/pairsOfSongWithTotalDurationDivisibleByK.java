//leetcode 1010
import java.util.*;
class pairsOfSongWithTotalDurationDivisibleByK{
	public static int numPairsDivisibleBy60(int[] time) {	
        int cnt = 0;
        int[] rem = new int[60];
        for(int t : time){
        	int r = t % 60;
        	if(r == 0){ 
        	 //why ? coz 60 % 60 && 0 % 60 == 0 
        	// and we are looking for 60 - r values in the array but r = 60 is never going to present in the array
        		cnt += rem[0];
        	}
        	else{
        		cnt += rem[60 - r];
        	}
        	rem[r]++;
        	//why we are updating the remainders at the end so to avoid duplicacy of pairs
        }
        return cnt;
    }
	public static void main(String[] args) {
		int[] arr = {30, 20, 150, 100, 40};
		System.out.println(numPairsDivisibleBy60(arr));
	}
}