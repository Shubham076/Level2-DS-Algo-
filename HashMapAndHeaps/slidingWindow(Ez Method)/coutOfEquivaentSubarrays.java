//count the number of subarrays having all the unique elements in the array
import java.util.*;
class coutOfEquivaentSubarrays{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i  = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		HashMap<Integer , Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for(int i : arr){
			set.add(i);
		}

		int k = set.size();
		int i = -1;
		int j = -1;
		int count = 0;
		while(true){
			boolean f1 = false;
			boolean f2 = false;

			while(i < arr.length - 1){
				f1 = true;
				i++;
				map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);

				if(map.size() == k){
					count += arr.length - i;
					break;
				}
			}

			while(j < i){
				f2 = true;
				j++;
				int freq = map.get(arr[j]);
				if(freq == 1){
					map.remove(arr[j]);
				}
				else{
					map.put(arr[j] , freq - 1);
				}

				if(map.size() == k){
					count += arr.length - i;
				}
				else if(map.size() < k){
					break;
				}
			}

			if(f1 == false && f2 == false){
				break;
			}

		}
		System.out.println(count);

	}
}