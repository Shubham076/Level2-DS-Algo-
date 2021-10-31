//count the number of subarrays having all the unique elements in the array
import java.util.*;
class countOfEquivaentSubarrays{
	static int method1(int[] nums, int k){
		HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() >= k) {
                cnt += nums.length - i;
                map.put(nums[j], map.get(nums[j]) - 1);
                if(map.get(nums[j]) == 0) map.remove(nums[j]);
                j++;
            }
        }
        return cnt;
	}
	static int method2(int[] arr, int k){
		HashMap<Integer , Integer> map = new HashMap<>();
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
		return count;
	}
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i  = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i : arr){
			set.add(i);
		}
		int k = set.size();

	}
}