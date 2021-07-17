/*  leetcode 1202  application os dsu

why dsu can be used ? 
if pairs are given as follows [1, 2] and [2, 3] means we can swap between 1, 2, 3 index
dsu will help finding all those pairs

now for finding the lexicographical smallest string we can use priority Queue
algorithm
eg string dcab pair [0, 3] and [1, 2];
after grouping if similar pairs 
par array looks like = [0, 1, 1, 0];
after this we create hashmap< Leader vs all its nodes whose leader is same>

string is    d  c  a  b
for constructing the smallest string
in first index out of all characters we can swap one with samllest comes first that is solved using priority quque
and which character we can swap can be find using using dsu
*/
import java.util.*;
public class smallestStringWithSwaps {
    static int[] par;
    static int[] rank;
    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }

    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                par[ly] = lx; 
            }
            else if(rank[ly] > rank[lx]){
                par[lx] = ly;
            }
            else{
                par[lx] = ly;
                rank[ly]++;
            }
        }
    }
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
        String ans = ""; 
        int n = s.length();
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            rank[i] = 1;
            par[i] = i;
        }

        for(List<Integer> p: pairs){
            int x = p.get(0);
            int y = p.get(1);
            union(x, y);
        }
        
        for(int i = 0; i < par.length; i++){
            int l = find(i);
            if(!map.containsKey(l)){
                PriorityQueue<Character> pq = new PriorityQueue<>();
                pq.add(s.charAt(i));
                map.put(l, pq);
            }
            else{
                map.get(l).add(s.charAt(i));
            }
        }

        // System.out.println(map);
        for(int i = 0; i < n; i++){
            int l = find(i); //extracting the leader
            ans += map.get(l).remove();
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "dcab";
        List<List<Integer>> list = new ArrayList<>();
        Integer[][] arr = {{0, 3}, {1, 2}};
        for(Integer[] a : arr){
            list.add(Arrays.asList(a));
        } 
        System.out.println(smallestStringWithSwaps(s, list));
    }
}
