//leetcode 905
class sortArrayByParity{
	public static void swap(int[] arr, int i, int j){
	       int temp = arr[i];
	       arr[i] = arr[j];
	       arr[j] = temp;
	   }
	   public static int[] sortArrayByParity(int[] a) {
	       int i = 0;
	       int j = 0;
	       while(i < a.length){
	           if(a[i] % 2 == 1){
	               i++;
	           }
	           else{
	               swap(a, i, j);
	               i++;
	               j++;
	           }
	       }
	       return a;
	   }
}