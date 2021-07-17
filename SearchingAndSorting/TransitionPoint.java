// Given a sorted array containing only numbers 0 and 1, the task is to find
// the transition point efficiently. The transition point is the point
// where 0 ends and 1 begins.
class TransitionPoint {
	public static void main(String[] args) {
		int[] arr = {0 , 0 , 0, 1};
		int lo = 0;
		int hi = arr.length - 1;
		int idx = -1;
		while(lo <= hi){
			int mid = lo + hi - lo / 2;
			if(arr[mid] == 1){
				idx = mid;
				hi = mid - 1;
			} 
			else{
				lo = mid + 1;
			}
		}
		System.out.println(idx);
	}
}