package segmentTree;

public class segmentTree {
    static int[] arr;
    static int[] seg;

    public static void build(int i, int l, int r) {
        if (l == r) {
            seg[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * i + 1, l, mid);
        build(2 * i + 2, mid + 1, r);
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public static int query(int i, int s, int e, int qs, int qe) {
        // case 1 complete overlap
        if (s >= qs && e <= qe) {
            return seg[i];
        }
        //no overlap
        // *qs-------*qe                       *qs-------*qe
        //                 *s-------------*e
        if (s > qe || e < qs) {
            return 0;
        }
        int mid = s + (e - s) / 2;
        int left = query(2 * i + 1, s, mid, qs, qe);
        int right = query(2 * i + 2, mid + 1, e, qs, qe);
        return left + right;
    }

    public static void update(int i, int s, int e, int qs, int qe, int inc) {
		//no overlap
		//     *qs----*qe                     *qs----*qe
 		//                 *s-------------*e
		if (s > qe || e < qs) {
			return;
		}
		//leaf node
		if(s == e){
			seg[i] += inc;
			return;
		}
		int mid = s + (e - s) / 2;
		update(2 * i + 1, s, mid, qs, qe, inc);
		update(2 * i + 2,  mid + 1, e, qs, qe, inc);
		seg[i] = seg[2 * i + 1] +  seg[2 * i + 2];
	}

    public static void main(String[] args) {
        arr = new int[]{2, 3, 1, -5, 4, 8, -7, 10, 3, 4};
        seg = new int[4 * arr.length + 1];
        build(0, 0, arr.length - 1);
//        for (int i : seg)
//            System.out.print(i + " ");
        update(0, 0, arr.length - 1, 3,3, 5);
        int ans = query(0, 0, arr.length - 1, 0, 4);
        System.out.println(ans);
    }
}
