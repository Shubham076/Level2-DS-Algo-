/*
1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.
Note -> Both arrays(A and B) are of the same length.

*/
import java.util.*;
public class findAnagramMappings {
    static class Pair{
        int i;
        ArrayList<Integer> arr;
        public Pair(int i, ArrayList<Integer> arr){
            this.i = i;
            this.arr = arr;
        }
    }                                                        
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scn.nextInt();
        }                                
        HashMap<Integer, Pair> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            b[i] = scn.nextInt();


            //for handling the duplicates mapping of element vs arrays of indexes of same element
            if(map.containsKey(b[i])){
                ArrayList<Integer> list = map.get(b[i]).arr;
                list.add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                Pair p = new Pair(0, list);
                map.put(b[i] , p);
            }
        }
        for(int i = 0; i < a.length; i++){
            Pair p = map.get(a[i]);
            ans[i] = p.arr.get(p.i);
            p.i++;
        }
        for(int i : ans)
            System.out.print(i + " ");
    }
}                                          