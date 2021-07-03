//leetcode 374
class guessNumberHigherOrLower{
	static int pick;
	public static int guess(int val){
		if(val > pick){
			return 1;
		}
		else if(val < pick){
			return -1;
		}
		else{
			return 0;
		}
	}
	public static int guessNumber(int n){
		int lo = 0;
		int hi = n;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(guess(mid) == 0){
				return mid;
			}
			else if(guess(mid) == 1){
				hi = mid - 1;
			}
			else{
				lo = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int n = 10;
		pick = 6;
		System.out.println(guessNumber(n));
	}
}