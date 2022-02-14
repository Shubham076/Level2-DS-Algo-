//https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
class cntArrayPairDivisibleByK{
	public static void main(String[] args){
		int[] arr = {1, 3, 2, 6, 1, 2};
		int k = 3;
		int[] map = new int[k + 1];
		int cnt = 0;
		for(int i = 0; i < arr.length; i++){
			int r = arr[i] % k;
			if(r == 0){
				cnt += map[r];
			}
			else{
				cnt += map[k - r];
			}
			map[r]++;
		}

		System.out.println(cnt);
	}
}