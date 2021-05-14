class moveAllNegativesToLeft{
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] arr = {2, -5, 7, -2, 3, -6};
		int i = 0;
		int j = 0;
		while(i < arr.length){
			if(arr[i] >= 0){
				i++;
			}
			else{
				swap(arr, i, j);
				j++;
				i++;
			}
		}

		for(int v : arr){
			System.out.print(v + " ");
		}
	}
}