import java.util.*;
public class findKClosest1 {
    // Time complexity nlogk + klogk
    static class Pair  implements Comparable<Pair>{
        int val;
        int gap;
        public Pair(int val, int gap){
            this.val = val;
            this.gap = gap;
        }

        @Override
        public int compareTo(Pair other){
            if(this.gap == other.gap){
                return this.val - other.val;
            }
            else{
                return this.gap - other.gap;
            }
        }
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> p = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            if(p.size() < k)
                p.add(new Pair(i, Math.abs(i - x)));
            else{
                if(p.peek().gap > Math.abs(i - x)){
                    p.remove();
                    p.add(new Pair(i, Math.abs(i - x)));
                }
        }

        while(p.size() > 0){
            ans.add(p.remove().val);
        }

        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
		int[] arr = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
		int k = 3, x = 5;
		System.out.println(findClosestElements(arr, k, x));
	}
}
