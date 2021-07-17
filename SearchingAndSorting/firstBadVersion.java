//leetcode 278
class firstBadVersion{
	public int firstBadVersion(int n) {
        int lo = 0;
        int hi = n;
        int ans = -1;
        while(lo <= hi){
        	int mid = lo + (hi - lo) / 2;
        	if(!isBadVersion(mid)){
        		lo = mid + 1;
        	}
        	else{
        		hi = mid - 1;
        		ans = mid;
        	}
        }
        return ans;
    }
}