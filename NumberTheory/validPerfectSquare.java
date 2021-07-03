//leetcode 367
class validPerfectSquare{
	// O(n ^ 1/ 2)
	public boolean isPerfectSquare(int num) {
    	int x = (int)Math.sqrt(num);
    	if(x * x == num){
    		return true;
    	}    
    	else{
    		return false;
    	}
    }
    // O(logn) using binary search
    public boolean isPerfectSquare2(int num){
    	long low = 0;
    	long high = num;
    	while(low <= high){
    		long mid = low + (high - low) / 2;
    		long t = mid * mid;
    		if(t == num){
    			return true;
    		}
    		else if(t < num){
    			low = mid + 1;
    		}
    		else{
    			high = mid - 1;
    		}
    	} 
    	return false;
    }
	public static void main(String[] args) {
		int n = 25;
	}
}