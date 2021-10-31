/*
a.compareto(b) return 0 => a == b
			   returns 1 => a > b => so b comes first
			   returns -1 => a < b => so a comes first
writing the above function inside the class that implements comparable is same
as writing the comparator in the using lambda function


ques => given an array sort the array such that
: all the even numbers comes before the odd numbers
: all even numbers that are divisible by 5 must come first than the even number not 
divisible by 5
: if 2 even numbers are divisible bt 5 number with the greater value comes first
: if 2 even numers are not divisible by 5 then the number having greater index comes first
: all odd numbers must maintain their relative ordering

if we want to sort in incresing order then return a - b or Integer.compare(a, b);
if we want to sort in decreasing order then return b - a or Integer.compare(b, a);
*/
import java.util.*;
class sortArray{
	static class Pair{
		int v;
		int i;
		Pair(int v, int i){
			this.v = v;
			this.i = i;
		}
	}
	public static void main(String[] args) {
		Integer[] arr = {5, 3, 10, 30, 26, 13};
		Pair[] list = new Pair[6];
		for(int i = 0; i < list.length; i++){
			list[i] = new Pair(arr[i] , i);
		}
		Arrays.sort(list, (a, b) -> {
			if(a.v % 2 == 0 && b.v % 2 == 0){
				if(a.v % 5 == 0 && b.v % 5 == 0){
					return b.v - a.v;
				}
				else if(a.v % 5 == 0 && b.v % 5 != 0){
					return -1;
				}
				else if(a.v % 5 != 0 && b.v % 5 == 0){
					return 1;
				}
				else{
					return b.i - a.i;
				}
			}
			else if(a.v % 2 == 0 && b.v % 2 != 0){
				return -1;
			}
			else if(a.v % 2 != 0 && b.v % 2 == 0){
				return 1;
			}
			else{
				return a.i - b.i;
			}
		});

		for(Pair i : list){
			System.out.print(i.v + " ");
		}
	}
}