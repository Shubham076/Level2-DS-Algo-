import java.util.*;
class factorialOfLargeNumber{
	static void multiply(int n, ArrayList<Integer> arr){
		int c = 0;
		for(int i = 0; i < arr.size(); i++){
			int v = arr.get(i) * n + c;
			arr.set(i, v % 10);
			c = v / 10;
		}
		while(c > 0){
			arr.add(c % 10);
			c /= 10;
		}
	}
	public static void main(String[] args){
		int n = 10;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		for(int i = 2; i <= n; i++){
			multiply(i, arr);
		}
		Collections.reverse(arr);
		System.out.println(arr);
	}
}