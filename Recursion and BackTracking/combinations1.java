public class combinations1 {
    // lb represents the last index that is filled
    //item chooses the boxes, ci = current item ti = total item lb = last box index
    // we are placing values in increasing order of index to avoiod repetetion
    public static void combinations(int[] boxes, int ci, int ti, int lb) {
        // write your code here
        if (ci > ti) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
            return;
        }

        for (int i = lb + 1; i < boxes.length; i++) {
            boxes[i] = 1;
            combinations(boxes, ci + 1, ti, i);
            boxes[i] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        combinations(new int[nboxes], 1, ritems, -1);
    }
}
