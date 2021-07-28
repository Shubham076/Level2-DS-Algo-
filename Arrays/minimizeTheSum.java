/*	https://www.geeksforgeeks.org/minimize-the-sum-calculated-by-repeatedly-removing-any-two-elements-and-inserting-their-sum-to-the-array/
  	Given N elements, you can remove any two elements from the list,
  	note their sum, and add the sum to the list. Repeat these steps
  	while there is more than a single element in the list. The task is
  	to minimize the sum of these chosen sums in the end.
*/
 import java.util.*; 
class minimizeTheSum{
	public static void main(String[] args) {
		int[] arr = {1, 4, 7, 10};
		int sum = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i : arr){
			q.add(i);
		}

		while(q.size() > 1){
			int a = q.remove();
			int b = q.remove();
			sum += (a + b);
			q.add(a + b);
		}
		System.out.println(q.peek() + " " + sum);
	}
}