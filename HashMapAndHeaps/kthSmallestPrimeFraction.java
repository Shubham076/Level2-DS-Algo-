/*
	leetcode 786
	the problem is similar to finding the minimum in sorted matrix
	we dont need to create an 2d matrix 
	[1,2,3,5]
	for this example
	the sorted mastric looks like
	1/5 1/3 1/2
	2/5 2/3
	3/5

	why the first number divided by 5 insted of 2 beacuse the larger value in deniminator the smaller is the fraction
	in this wasy we chave a sorted matrix

	but we dont need to create a sorted matri;
	we will add indexes for fraction in the priority queue write a custom comparator
*/
import java.util.*;
class kthSmallestPrimeFraction{
	public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		//	a1/b1 , a2/b2 how to find which one is greater simply do a1 * b2 and b1 * a1 if(a1 * b2 > b1 * a1) the a1/b1 is greater

		//structure of int[] arr in queues => arr[0] = index of numerator and index of arr[1] represents denominator
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
        	int s1 = arr[a[0]] * arr[b[1]];
        	int s2 = arr[b[0]] * arr[a[1]];
        	return s1 - s2;	
        });
        int n = arr.length;
        for(int i = 0; i < arr.length; i++){
        	q.add(new int[] {i, n - 1});
        }  

        int cnt = 0;
        while(q.size() > 0){
        	int[] rm = q.remove();
        	cnt++;

        	if(cnt == k){
        		return new int[] {arr[rm[0]], arr[rm[1]]};
        	}

        	//decrementing the denominator
        	rm[1]--;
        	if(rm[1] > rm[0]){
        		q.add(rm);
        	}
        }
        return new int[0];
    }
}