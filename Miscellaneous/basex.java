import java.util.*;
import java.io.*;

public class basex{

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
    
    public static void main(String[] args){
        int t = f.nextInt();
        for(int i = 1; i <= t; i++){
            // print("Case #" + i + ": ");
            solve();
        }
        out.close();
        err.close();
    }

    public static double cnt(long n, int k){
    	//for the cnt of no of digits in base k of a decimal number
    	int cnt = 0;
    	while(n > 0){
    		n /= k;
    		cnt++;
    	}
    	return cnt;
    }

    public static void solve(){
      long n = f.nextInt();
      int k = f.nextInt();
      double ans = 0;
      for(int i = 1; i <= n; i++){
      	ans += cnt(i, k);
      }
      println((long)(ans) + 1);
    }
}