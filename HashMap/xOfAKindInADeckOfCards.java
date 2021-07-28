//leetcode 914
import java.util.*;
class xOfAKindInADeckOfCards {
	public static int gcd(int a, int b){
		return b == 0 ? a : gcd(b , a % b);
	}
	public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 1){
        	return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < deck.length; i++){
        	map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        if(map.size() == 1){
        	return true;
        }

        int g = 0;
        for(int i: map.values()){
        	g = gcd(g, i);
        }

        if(g > 1){
        	return true;
        }
        else{
        	return false;
        }
    }
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
		System.out.println(hasGroupsSizeX(arr));
	}
}