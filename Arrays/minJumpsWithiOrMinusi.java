// https://www.geeksforgeeks.org/find-the-number-of-jumps-to-reach-x-in-the-number-line-from-zero/
//leetcode 754
class minJumpsWithiOrMinusi{
	public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 0;
        int cnt = 1;
            while(true){
            i = i + cnt;
            if(i == target){
                return cnt; 
            }
            else if(i > target && (i - target) % 2 == 0){
                return cnt;
            }
            
            cnt++;
            }
    }
}