import java.util.*;
class generateBinaryNumbers{
	public static void main(String[] args){
		int n = 10;
		Queue<String> q = new ArrayDeque<>();
		q.add("1");
		while(n-- > 0){
			String rm = q.remove();
			System.out.println(rm);
			q.add(rm + "0");
			q.add(rm + "1");
		}
	}
} 