//leetcode 1710
/*
	we want to amaximize the number of units so so grsit start with the boxes that have maximum units
*/
import java.util.*;
class maximumUnitsInATruck{
	public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int sum = 0;
        int cnt = 0;
        for(int[] a: boxTypes){
        	if(cnt + a[0] <= truckSize){
        		cnt += a[0];
        		sum += a[0] * a[1];
        	}
        	else{
        		for(int i = 0; i < a[0]; i++){
        			if(cnt + 1 <= truckSize){
        				cnt++;
        				sum += a[1];
        			}
        		}
        	}
        }
        return sum;
    }

	public static void main(String[] args) {
		int[][] arr = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
		int size = 10;
		System.out.println(maximumUnits(arr, size));
	}
}