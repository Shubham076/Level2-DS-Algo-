/*
when we are swap a number at a greater place then impact is seen at greater place

for eg -> 532 if we replace 5 with 2 then the number becomes 252 which is smaller
so we can say if we swap to any higher index then then number at higher idx after swapping decides
whether number is increased or not

for eg => 12345
so the point is we swap the number 4 with any of the digits on the left then impact is shown
on the left numbers instead of 4;

as we have to find the minimum number so we try to change the min idx
and to show the impact at particular idx we must swap with numbers on the smaller place value 
*/

import java.util.*;
class nextgreaterElement111{
	public static void swap(int i, int j, ArrayList<Integer> list){
		int ith = list.get(i);
		int jth = list.get(j);
		list.set(i, jth);
		list.set(j, ith);
	}

	public static void reverse(int p, int q, ArrayList<Integer> list){
		while(p < q){
			swap(p , q, list);
			p++;
			q--;
		}
	}  
	public static int nextGreaterElement(int n) {
		int idx1 = -1;
		int idx2 = -1;
		int no = n;
		ArrayList<Integer> list = new ArrayList<>();
		String ans = "";
		while(no > 0){
			int d = no % 10;
			no /= 10;
			list.add(0, d);
		}
		
		for(int i = list.size() - 1; i > 0; i--){
			int cur = list.get(i);
			int prev = list.get(i - 1);
			if(prev < cur){
				idx1 = (i - 1);
				break;
			}
		}

		if(idx1 == -1) return -1;

		int prev = list.get(idx1);
		for(int i = idx1 + 1; i < list.size(); i++){
			int cur = list.get(i);
			if(cur > prev){
				idx2 = i;
			}
		}
		
		swap(idx1, idx2 , list);
		reverse(idx1 + 1 , list.size() - 1, list);
		for(int i : list){
			ans += i; 
		}

     	long val =  Long.parseLong(ans);
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
	public static void main(String[] args){
		int n = 137654;
		System.out.println(nextGreaterElement(n));
	}
}