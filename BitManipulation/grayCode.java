//print N bit grey code
import java.util.*;
class grayCode{

	//recursive method
	    public static List<Integer> grayCode(int n) {
        if(n == 0){
            List<Integer> bl = new ArrayList<>();
            bl.add(0);
            return bl;
        }
        List<Integer> rl = grayCode(n - 1);
        int no = (int)Math.pow(2, n - 1);
        int size = rl.size() - 1;
        for(int i = size; i >= 0; i--){
            int v = rl.get(i) + no;
            rl.add(v);
        }
        return rl;
    }

	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(grayCode(n));

		
		// using bit manipulation
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		for(int i = 0; i < n; i++){
			int prepend = 1 << i;
			int size = list.size();
			for(int j = size - 1; j >= 0; j--){
				list.add(list.get(j) + prepend);
			}
		}
		System.out.println(list);
	}
}