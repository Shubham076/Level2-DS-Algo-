import java.util.*;
class arrayPairsDivisibleByK{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		scn.close();
		System.out.println(doPairsExist(arr , k));
	}

	public static boolean doPairsExist(int[] arr , int k){
		HashMap<Integer , Integer> map = new HashMap<>();
		for(int val : arr){
			int r = val % k;
			map.put(r , map.getOrDefault(r , 0) + 1);
		}

		for(int val : arr){
			int rem = val % k;

			if(rem == 0){
				int count = map.get(rem);
				if(count % 2 == 1){
					return false;
				}

			}
			else if(rem == k / 2){
				int count = map.get(rem);
				if(count % 2 == 1){
					return false;
				}
			}

			else{
				int count = map.get(rem);
				int ocount = map.get(k - rem);

				if(count != ocount){
					return false;
				}
			}
		}
		return true;
	}
}