package practise;
import java.util.*;

class Main {
    static int[] par;
    static int[] size;

    static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }
    static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);

        if(lx != ly){
            if(size[lx] <= size[ly]){
                par[lx] = ly;
                size[ly] += size[lx];
            }
            else{
                par[ly] = lx;
                size[lx] += size[ly];
            }

            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}, {3, 5}, {6, 7}};
        int n = 7;
        par = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int[] e: edges){
            union(e[0] - 1, e[1] - 1);
        }
        HashMap<Integer, HashSet<Integer>> comps = new HashMap<>();
        for(int i = 0; i < n; i++){
            int px = find(i);
            comps.putIfAbsent(px, new HashSet<>());
            comps.get(px).add(i);
        }
        System.out.println(comps);
    }
}