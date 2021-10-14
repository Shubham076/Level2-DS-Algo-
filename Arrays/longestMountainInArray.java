//leetcode 845
class longestMountainInArray{
	//O(N)
	public static int longestMountain(int[] arr) {
        //the idea to move forwards and backwards from every peek;
        // first index and last index can never be an peek
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length - 1;){

        	//peek found
        	if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]){
        		int cnt = 1;  //current number included
        		
        		//move backwards
        		int j = i;
        		while(j >= 1 && arr[j] > arr[j - 1]){
        			cnt++;
        			j--;
        		}

        		//move forwards
        		while(i <= arr.length - 2 && arr[i] > arr[i + 1]){
        			i++;
        			cnt++;
        		}
        		max = Math.max(max , cnt);
        	}
        	else{
        		// move forward if not a peek
        		i++;
        	}
        }
        return max;
    }
	public static void main(String[] args){
		int[] arr = {0, 1, 0};
		System.out.println(longestMountain(arr));
	}
}