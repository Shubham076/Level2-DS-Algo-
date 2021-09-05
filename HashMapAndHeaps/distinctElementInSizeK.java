import java.util.*;
class distinctElementInSizeK{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < k - 1; i++){
			map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
		}

		for(int j = 0, i = k - 1; i < arr.length;){
			map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1);
			System.out.print(map.size() + " ");
			int count = map.get(arr[j]);
			if(count > 1){
				map.put(arr[j], count - 1);
			}
			else{
				map.remove(arr[j]);
			}
			i++;
			j++;
		}
	}
}