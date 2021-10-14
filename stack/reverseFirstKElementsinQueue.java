//https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1
import java.util.*;
class reverseFirstKElementsinQueue{
	public Queue<Integer> modifyQueue(Queue<Integer> q, int k){
      Stack<Integer> s = new Stack<>();
      int n = q.size();
      for(int i = 0; i < k; i++){
          s.add(q.remove());
      }
      
      while(s.size() > 0){
          q.add(s.pop());
      }
      
      for(int i = 1; i <= n - k; i++){
          q.add(q.remove());
      }
      return q;
    }
}