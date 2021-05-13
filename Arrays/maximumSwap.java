//https://leetcode.com/problems/maximum-swap/discuss/107073/C%2B%2B-one-pass-simple-and-fast-solution%3A-1-3ms-O(n)-time
//leetcode 670
class maximumSwap{
	public static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	 public static int maximumSwap(int num) {
     	char[] arr = Integer.toString(num).toCharArray();
     	int maxidx = -1; int maxdigit = -1;
     	int leftidx = -1; int rightidx = -1;        

     	for (int i = arr.length - 1; i >= 0; --i) {
     	    // current digit is the largest by far
     	    if (arr[i] - '0' > maxdigit) {
     	        maxdigit = arr[i] - '0';
     	        maxidx = i;
     	    }

     	    // best candidate for max swap if there is no more 
     	    // such situation on the left side
     	    if (arr[i] - '0' < maxdigit) {
     	        leftidx = i;
     	        rightidx = maxidx;
     	    }
     	}
     	// num is already in order
     	if (leftidx == -1) return num;
     	swap(arr, leftidx, rightidx);
     	return Integer.parseInt(new String(arr));   
    }
	public static void main(String[] args){
		int n = 7236;
		System.out.println(maximumSwap(n));
	}
}