import java.util.*;
class largestSubarrayWith0Sum{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0 , -1);
		int sum = 0;
		int len = 0;
		int si = -1;
		int ei = -1;
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}

		for(int i = 0; i < arr.length; i++){
			sum += arr[i];

			if(!map.containsKey(sum)){
				map.put(sum , i);
			}
			else{
				int curLength = i - map.get(sum);
				if(curLength > len){
					len = curLength;
					si = map.get(sum) + 1;
					ei = i;
				}
			}
		}

		System.out.println(len);
		printSubArray(si , ei , arr);


	}

	public static void printSubArray(int start , int end , int[] arr){
		for(int i = start; i <= end; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}