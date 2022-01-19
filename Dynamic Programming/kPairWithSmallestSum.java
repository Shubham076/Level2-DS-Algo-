//leetcode 373 O(nlogk)
import java.util.*;
class kPairWithSmallestSum{
	static class Pair{
		int n1;
		int n2;
		int idx;
		Pair(int n1, int n2, int idx){
			this.n1 = n1;
			this.n2 = n2;
			this.idx = idx;
		}
		public String toString(){
			return this.n1 + " " + this.n2;
		}
	}
	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return list;
        Queue<Pair> q = new PriorityQueue<>((a, b) ->{
        	int s1 = a.n1 + a.n2;
        	int s2 = b.n1 + b.n2;
        	return s1 - s2;
        });
        for(int i = 0; i < nums1.length; i++){
        	q.add(new Pair(nums1[i], nums2[0], 0));
        }

        while(q.size() > 0){
        	Pair p = q.remove();
        	k--;
        	list.add(Arrays.asList(p.n1, p.n2));
        	if(k == 0) break;
        	p.idx++;

        	if(p.idx < nums2.length){
        		p.n2 = nums2[p.idx];
        		q.add(p);
        	}
        }
        return list;
    }
	public static void main(String[] args){
		int[] a = {1, 7, 11};
		int[] b = {2, 4, 6};
		int k = 3;
		System.out.println(kSmallestPairs(a, b, k));
	}
}