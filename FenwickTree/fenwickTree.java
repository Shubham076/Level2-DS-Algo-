import java.util.*;
import java.io.*;

public class fenwickTree{

    static class fastReader{
        BufferedReader br;
        StringTokenizer st;

        public fastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        } 

        String Next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(Next());
        }

        float nextFloat(){
            return Float.parseFloat(Next());
        }

        boolean nextBoolean(){
            return Boolean.parseBoolean(Next());
        }

        double nextDouble(){
            return Double.parseDouble(Next());
        }

        long nextLong(){
            return Long.parseLong(Next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        String next(){
            return Next();
        }
    }
    static int int_max = Integer.MAX_VALUE;
    static int int_min = Integer.MIN_VALUE;

    private static final fastReader f = new fastReader();
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    private static final PrintWriter err = new PrintWriter(new BufferedOutputStream(System.err));

    public static void print(Object o){out.print(o);}
    public static void println(Object o){out.println(o);}
    public static void println(){out.println();}

    public static void debug(Object o){err.print(o);}
    public static void debugln(Object o){err.println(o);}
    public static void debugln(){err.println();}
    
    public static<T extends Comparable<T>> T max(T a , T b){return a.compareTo(b) > 0 ? a : b;}
    public static<T extends Comparable<T>> T min(T a , T b){return a.compareTo(b) > 0 ? b : a;}
    
    //O(Logn)
    public static long prefixsum(int i){
        long sum = 0;
        while(i > 0){
            sum += farr[i];
            i = i - (i & -i);
        }
        return sum;
    } 
    // O(logn)
    public static void update(int i, int val){
        while(i < farr.length){
            farr[i] += val;
            i +=  (i & -i);
        }
    }
    public static void solve(){
        char c = f.next().charAt(0);
        int l = f.nextInt();
        int r = f.nextInt();
        if(c == 'u'){
            update(l, r);
            return;
        }
        long ans = prefixsum(r) - prefixsum(l - 1);
        println(ans);
    }
    
    static int[] farr;
    //O(NlogN)
    public static void preprocess(int[] arr){
        farr = new int[arr.length + 1];
        for(int i = 1; i < arr.length; i++){
            update(i, arr[i]);
        }
    }
    public static void main(String[] args){
        int n = f.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = f.nextInt();
        }
        preprocess(arr);
        int q = f.nextInt();
        for(int i = 1; i <= q; i++){
            // print("Case #" + i + ": ");
            solve();
        }
        out.close();
        err.close();
    }
}