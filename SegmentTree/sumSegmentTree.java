import java.util.*;
class sumSegmentTree{
	static class SegTree{
		int[] tree;
		int[] arr;
		SegTree(int[] arr){
			this.arr = arr;
			tree = new int[4 * arr.length];
		}
		//O(n) n is the number of nodes in the tree
		void build(int i, int s, int e){
			//leaf node
			if(s == e){
				tree[i] = arr[s];
				return; 
			}
			int mid = s + (e - s) / 2;
			build(2 * i + 1, s, mid);
			build(2 * i + 2, mid + 1, e);
			tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
		}

		/*  cases
			1: no overlap
           *qs-------*qe                       *qs-------*qe
                          *s-------------*e
			
			2: complete overlap
            *qs----------*qe  
               *s----*e

            3: partial overlap
                     *qs-------*qe                    
                          *s-------------*e
		*/
		//O(logn)
		int query(int i, int s, int e, int qs, int qe){
			//case 1 no overlap
			if(s > qe || e < qs){
				return 0;
			}

			//case 2 complete overlap
			if(s >= qs && e <= qe){
				return tree[i];
			} 

			//case 3 partial overlap
			int mid = s + (e - s) / 2;
			int left = query(2 * i + 1, s, mid, qs, qe);
			int right = query(2 * i + 2, mid + 1, e, qs, qe);
			return left +  right;
		}

		//O(logn) point update
		void update(int i, int s, int e, int p, int v) {
		    if (s > p || e < p) {
		        return;
		    }
		    //leaf node
		    if (s == e) {
		    	  arr[s] = v;
		        tree[i] = v;
		        return;
		    }
		    int mid = s + (e - s) / 2;
		    update(2 * i + 1, s, mid, p, v);
		    update(2 * i + 2,  mid + 1, e, p, v);
		    tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
		}

		//O(n) range update
		void rupdate(int i, int s, int e, int qs, int qe, int v) {
		    if (s > qe || e < qs) {
		        return;
		    }
		    //leaf node
		    if (s == e) {
		    	  arr[s] += v;
		        tree[i] += v;
		        return;
		    }
		    int mid = s + (e - s) / 2;
		    rupdate(2 * i + 1, s, mid, qs, qe, v);
		    rupdate(2 * i + 2,  mid + 1, e, qs, qe, v);
		    tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
		}
	}
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int n = arr.length;
		SegTree t = new SegTree(arr);
		t.build(0, 0, n - 1);
		t.update(0, 0 , n - 1, 9, -5);
		int ans = t.query(0, 0, n - 1, 0, 9);
		System.out.println(Arrays.toString(arr));
		System.out.println(ans);
	}
}