public class combinations2{
    //ti = total item , tb = total box, cb = current box , ci = current item
    //when box choses the item
    public static void combinations(int cb, int tb, int ci, int ti, String asf){
        // write your code here
        if(cb > tb){
            if(ci == ti){
                System.out.println(asf);
            }
            return;
        }

        //2 choices ya to item le ya phir na le
        combinations(cb + 1, tb, ci + 1, ti , asf + "i");
        combinations(cb + 1, tb, ci, ti , asf + "-");
      }
    
      public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        combinations(1, nboxes, 0, ritems, "");
      }
}
