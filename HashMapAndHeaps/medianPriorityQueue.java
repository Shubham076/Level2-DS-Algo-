/*
make 2 priority queue
left one is max heap stores the smaller half
right one is min  heap stores the bigger half

*/
import java.util.*;
class medianPriorityQueue{
	PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;
	medianPriorityQueue(){
		left = new PriorityQueue<>(Collections.reverseOrder());
		right = new PriorityQueue<>();
	}

	public void add(int val){
		//generally add val in left , val is added in right only if it is greater than the peek of right
		if(right.size() > 0 && val > right.peek()){
			right.add(val);
		}
		else{
			left.add(val);
		}

		//after adding we have to check if the diff between size of both left and right > 1
		if(left.size() - right.size() == 2){
			right.add(left.remove());
		}
		else if(right.size() - left.size() == 2){
			left.add(right.remove());
		}
	}

	public int remove(){
		if(this.size() == 0){
			System.out.println("Queue is empty");
			return -1;
		}
		//whichever q has greater removes its peek otherwise if both are same remove peek of left;
		else if(left.size() >= right.size()){
			return left.remove();
		}
		else{
			return right.remove();
		}
	}

	public int peek(){
		if(this.size() == 0){
			System.out.println("Queue is empty");
			return -1;
		}
		//whichever q has greater returns its peek otherwise if both are same return peek of left;
		else if(left.size() >= right.size()){
			return left.peek();
		}
		else{
			return right.peek();
		}
	}

	public int size(){
		return left.size() + right.size();
	}

	public static void main(String[] args){
		int[] arr = {2, 1, 5, 6 , 7, 8};
		medianPriorityQueue q = new medianPriorityQueue();
		for(int i = 0; i < arr.length; i++){
			q.add(arr[i]);
			System.out.println("Median upto length " + (i + 1) + ": " + q.peek());
		}
	}
}