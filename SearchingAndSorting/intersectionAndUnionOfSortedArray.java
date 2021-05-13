import java.util.*;
class intersectionAndUnionOfSortedArray{
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] arr1 = new int[n];
		int[] arr2 = new int[m];

		for(int i = 0; i < n; i++){
			arr1[i] = scn.nextInt();
		}

		for(int i = 0; i < m; i++){
			arr2[i] = scn.nextInt();
		}

		union(arr1 , arr2);
		intersection(arr1 , arr2);	
	}

	public static void union(int[] arr1 , int[] arr2){
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0; 
		int j = 0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] == arr2[j]){
				if(list.size() > 0 && list.get(list.size() - 1) != arr1[i]){
					list.add(arr1[i]);
				}
				else if(list.size() == 0){
					list.add(arr1[i]);
				}
				i++;
				j++;
			}
			else if(arr1[i] < arr2[j]){
				if(list.size() > 0 && list.get(list.size() - 1) != arr1[i]){
					list.add(arr1[i]);
				}
				else if(list.size() == 0){
					list.add(arr1[i]);
				}
				i++;
			}
			else{
				if(list.size() > 0 && list.get(list.size() - 1) != arr2[j]){
					list.add(arr2[j]);
				}
				else if(list.size() == 0){
					list.add(arr2[j]);
				}
				j++;
			}
		}

		while(i < arr1.length){
			if(list.get(list.size() - 1) != arr1[i]){
				list.add(arr1[i]);
			}
			i++;
		}
		while(j < arr2.length){
			if(list.get(list.size() - 1) != arr2[j]){
				list.add(arr2[j]);
			}
			j++;
		}

		System.out.println(list);
	}

	public static void intersection(int[] arr1 , int[] arr2){
		int i = 0; 
		int j = 0;
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				i++;
			}
			else if(arr1[i] > arr2[j]){
				j++;
			}
			else{
				System.out.print(arr1[i] + " ");
				i++;
				j++;
			}
		}	
	}
}