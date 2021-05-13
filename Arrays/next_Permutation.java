import java.util.*;
import java.io.*;
public class next_Permutation {
    
    public static<T extends Comparable<T>> void swap(ArrayList<T> list, int i, int j){
        T ith = list.get(i);
        T jth = list.get(j);
        list.set(i, jth);
        list.set(j, ith);
    }

    public static<T extends Comparable<T>> void reverse(int p, int q, ArrayList<T> list){
		while(p < q){
			swap(list, p ,q);
			p++;
			q--;
		}
	} 

    public static<T extends Comparable<T>> boolean nextPermutation(ArrayList<T> list){
        int idx1 = -1;
		int idx2 = -1;
		
		for(int i = list.size() - 1; i > 0; i--){
			T cur = list.get(i);
			T prev = list.get(i - 1);
			if(prev.compareTo(cur) < 0){
				idx1 = (i - 1);
				break;
			}
		}

		if(idx1 == -1) return false;

		T prev = list.get(idx1);
		for(int i = idx1 + 1; i < list.size(); i++){
			T cur = list.get(i);
			if(cur.compareTo(prev) > 0){
				idx2 = i;
			}
		}
		
		swap(list, idx1, idx2);
        reverse(idx1 + 1 , list.size() - 1, list);
        return true;
    }

	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Character> arr = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			char c = (char)('a' + i);
			arr.add(c);
		}

		do{
			out.println(arr);
		}
		while(nextPermutation(arr));
		out.close();
	}
}
