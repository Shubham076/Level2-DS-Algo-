import java.util.*;
public class equalsAndHashcodeOveride {
    static class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o){
	    if(this == o) return true; //address is same
            if(o == null) return false;
            Pair other = (Pair)o;
            if(this.i == other.i && this.j == other.j){
                return true;
            }
            else{
                return false;
            }
        }

        @Override
        public int hashCode(){
            return i % 30;
        }

        @Override
        public String toString(){
            return "(" + this.i + "," + this.j + ")";
        }
    }
    public static void main(String[] args){
        LinkedHashMap<Pair, Integer> map = new LinkedHashMap<>();
        map.put(new Pair(10, 20), 1);
        map.put(new Pair(10, 20), 1);
        map.put(new Pair(20, 30), 1);
        System.out.println(map);
    }
}
