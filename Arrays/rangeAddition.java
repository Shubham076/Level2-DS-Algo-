//lintcode 903
class rangeAddition{
	public static int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] arr = new int[length];
        for(int[] q :  updates){
        	int s = q[0];
        	int e = q[1];
        	int v = q[2];
        	arr[s] += v;
        	if((e + 1) < length)
        		arr[e + 1] -= v;
        }

        for(int i = 1; i < length; i++){
        	arr[i] += arr[i - 1];
        }
        return arr;
    }

	public static void main(String[] args){
		int[][] arr = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
		int[] ans = getModifiedArray(5, arr);
		for(int i : ans){
			System.out.print(i + " ");
		}
	}
}