//leetcode 179
import java.util.*;
class largestNumber{
	public static String largestNumber(int[] arr) {
        String[] a = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            a[i] = arr[i] + "";
        }
        Arrays.sort(a, (p, q) -> {
            long n1 = Long.parseLong(p + q);
            long n2 = Long.parseLong(q + p);
            if(n1 > n2){
                return -1;
            }
            else{
                return 1;
            }
        });
        String ans = "";
        for(int i = 0; i < a.length ; i++){
            ans += a[i];
        }
        if(ans.charAt(0) == '0'){
            return "0";
        }
        else
            return ans;
    }

	public static void main(String[] args){
		System.out.println(largestNumber(new int[]{10, 2}));
	}
}