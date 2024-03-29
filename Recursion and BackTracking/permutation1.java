class permutation1{
    //items are choosing the box in this case  ci = current item , ti = total item
    public static void permutations(int[] boxes, int ci, int ti){
        // write your code here
        if(ci > ti){
            for(int i = 0; i < boxes.length; i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i] == 0){
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }
    
      public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        permutations(new int[nboxes], 1, ritems);
      }
}