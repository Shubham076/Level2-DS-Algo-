//leetcode 849
class maximizeDistanceToClosestPerson {
	public static int maxDistToClosest(int[] seats) {
        int last = -1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < seats.length; i++){
        	if(seats[i] == 1){
        		if(last == -1){
        			ans = i;
        		}
        		else{
        			ans = Math.max(ans , (i - last) / 2);
        		}

        		last = i;
        	}
        }
        ans = Math.max(ans, (seats.length - 1 - last));
        return ans;
    }

	public static void main(String[] args) {
		int[] seats = {1, 0, 0, 0, 1, 0, 1};
		System.out.println(maxDistToClosest(seats));
	}
}