class segregate0And1{
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static void binSort(int a[], int N){
		int j = 0;
		int i = 0;
		while(i < a.length){
			if(a[i] == 1){
				i++;
			}
			else{
				swap(a, i, j);
				i++;
				j++;
			}
		}
	}
	public static void main(String[] args){
		int[] arr = {1, 0, 1, 1, 0};
		binSort(arr, 5);
		for(int i : arr){
			System.out.print(i + "  ");
		}
	}
}