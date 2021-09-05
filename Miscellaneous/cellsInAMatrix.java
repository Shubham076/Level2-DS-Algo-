import java.util.*;
public class cellsInAMatrix {
    public static void main(String[] args){
        int n = 5;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        int[][] queries = {{3, 2}, {4, 4}, {3, 5}};
        
        for(int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            int r = q[0];
            int c = q[1];
            row.add(r);
            col.add(c);
            int ans = (n - row.size()) * (n - col.size());
            System.out.println(ans);
        }
    }
    
}
