import java.util.*;
class sumSegmentTree_lazyUpdate{
	static class SegTree{
		int[] tree;
		int[] arr;
		int[] lazy;
		SegTree(int[] arr){
			this.arr = arr;
			tree = new int[4 * arr.length];
			lazy = new int[4 * arr.length];
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

		void propagate(int i, int s, int e){
			//leaf node
			if(lazy[i] != 0){
				if(s == e){
					arr[s] += lazy[i];
					tree[i] += lazy[i];
					lazy[i] = 0; 
				}
				else{
					//means node representing range
					tree[i] += lazy[i] * (e - s + 1);
					lazy[2 * i + 1] = lazy[i];
					lazy[2 * i + 2] = lazy[i];
					lazy[i] = 0;
				}
			}
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
			propagate(i, s, e);

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

		//O(logn) range update (lazy update)
		void rupdate(int i, int s, int e, int qs, int qe, int v) {
		    propagate(i, s, e);
		    if (s > qe || e < qs) {
		        return;
		    }
		    //leaf node
		    if (s == e) {
		    	arr[s] += v;
		        tree[i] += v;
		        return;
		    }
		    //complete overlap
		    if(s >= qs && e <= qe){
		    	lazy[i] += v;
		    	propagate(i, s, e);
		    	return;
		    }
		    int mid = s + (e - s) / 2;
		    rupdate(2 * i + 1, s, mid, qs, qe, v);
		    rupdate(2 * i + 2,  mid + 1, e, qs, qe, v);
		    tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
		}
	}
	public static void main(String[] args){
		int[] arr = {1, 1, 1, 1, 1, 1, 1, 1};
		int n = arr.length;
		SegTree t = new SegTree(arr);
		t.build(0, 0, n - 1);
		t.rupdate(0 , 0 , n - 1, 0, 7, 1);
		int ans = t.query(0, 0, n - 1, 0, 7);
		System.out.println(Arrays.toString(arr));
		System.out.println(ans);
	}
}