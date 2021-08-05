/*
https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
There are given N ropes of different lengths, we need to connect these ropes
into one rope. The cost to connect two ropes is equal to sum of their
lengths. The task is to connect the ropes with minimum cost.
*/
import java.util.*;
class connectNRopes{
	long minCost(long arr[], int n){
         PriorityQueue<Long> q = new PriorityQueue<>();
         for(long i : arr)
         	q.add(i);
         long cost = 0;
         while(q.size() > 1){
         	long x = q.remove();
         	long y = q.remove();
         	long sum = x + y;
         	cost += sum;
         	q.add(sum);
         }
         return cost;
    }
}