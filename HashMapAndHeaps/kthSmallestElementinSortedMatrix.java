/*
leetcode 378
we will use min heap to find the kth smallest element
add the first element of each row as out of these three we found the first smallest element

note for finding the kth largest element
add the last elements of each row in the max heap

timec complexity KlogN where n is the number of rows
*/
import java.util.*;
class kthSmallestElementinSortedMatrix{
	static class Pair implements Comparable<Pair>{
		int n;
		int r;
		int i;
		Pair(int n, int r, int i){
			this.n = n;
			this.r = r;
			this.i = i;
		}

		@Override
		public int compareTo(Pair o){
			return this.n -  o.n;
		}
	}
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i = 0; i < matrix.length; i++){
        	q.add(new Pair(matrix[i][0], i, 0));
        }	
        int cnt = 0;
        while(q.size() > 0){
        	Pair rm = q.remove();
        	cnt++;

        	if(cnt == k){
        		return rm.n;
        	}
        	rm.i++;
        	if(rm.i < matrix[0].length){
        		rm.n = matrix[rm.r][rm.i];
        		q.add(rm);
        	}
        }
        return -1;
    }
}