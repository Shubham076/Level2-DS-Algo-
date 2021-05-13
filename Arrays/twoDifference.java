import java.util.*;
class twoDifference{
	public static boolean findPair(int arr[], int size, int n){
        Arrays.sort(arr);
        int i = 0, j = 0;
        while(i < arr.length){
        	int diff = arr[j] - arr[i];
        	if(i != j && diff == n){
        		System.out.println(arr[j] + " " + arr[i]); 
        		return true;
        	}
        	else if(diff > n) i++;
        	else j++;
        }
        return false;
    }
	public static void main(String[] args){
		int[] arr = {5, 20, 3, 2, 50, 80};
		System.out.println(findPair(arr, arr.length, 30));
	}
}