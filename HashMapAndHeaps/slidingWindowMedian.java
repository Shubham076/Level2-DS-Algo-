//leetcode 480 O(n * k / 2) why k / 2 because removing a particular element take o(n) tume where n is the no of elements in heap
import java.util.*;
class slidingWindowMedian {
	static class MedianPq {
		PriorityQueue<Integer> left;
		PriorityQueue<Integer> right;
		MedianPq() {
			left = new PriorityQueue<>(Collections.reverseOrder());
			right = new PriorityQueue<>();
		}

		public void balance(){
			if (left.size() - right.size() == 2) {
				right.add(left.remove());
			}
			else if (right.size() - left.size() == 2) {
				left.add(right.remove());
			}
		}

		public void add(int val) {
			//generally add val in left , val is added in right only if it is greater than the peek of right
			if (right.size() > 0 && val > right.peek()) {
				right.add(val);
			} 
			else {
				left.add(val);
			}

			//after adding we have to check if the diff between size of both left and right > 1
			this.balance();
		}

		public void remove(int val) {
			if(val > left.peek()){
				right.remove(val);
			}
			else{
				left.remove(val);
			}
			balance();
		}

		public int peek() {
			if (this.size() == 0) {
				System.out.println("Queue is empty");
				return -1;
			}
			//whichever q has greater returns its peek otherwise if both are same return peek of left;
			else if (left.size() >= right.size()) {
				return left.peek();
			}
			else {
				return right.peek();
			}
		}

		public double median(int k){
			return k % 2 == 0 ? ((double) left.peek () + right.peek ()) / 2 : this.peek();
		}

		public int size() {
			return left.size() + right.size();
		}
	}
	public double[] medianSlidingWindow(int[] nums, int k) {
    	double[] ans = new double[nums.length - k + 1];
    	MedianPq q = new MedianPq();
    	for(int i = 0; i < k - 1; i++){
    		q.add(nums[i]);
    	}

    	int j = 0;
    	for(int i = k - 1; i < nums.length; i++){
    		q.add(nums[i]);
    		ans[j] = q.median(k);
    		q.remove(nums[j++]);
    	}
    	return ans;   
    }
}