public class permutations2 {
	//si = selected items ti = total items cb = current box tb = total box , adf = answer so far
	//box chosing the items
    public static void permutations(int cb, int tb, int[] items, int si, int ti, String asf){
        // write your code here
        if(cb > tb){
        	if(si == ti){
        		System.out.println(asf);
        	}
        	return;
        }

        for(int i = 0; i < ti; i++){
        	if(items[i] == 0){       //not selected
        		items[i] = 1;
        		permutations(cb + 1, tb, items, si + 1, ti, asf + (i + 1));
        		items[i] = 0;
        	}
        }
        // box not slecting the items
        permutations(cb + 1, tb, items, si, ti, asf + 0);
      }
    
      public static void main(String[] args) throws Exception {
        int nboxes = 5;
        int ritems = 3;
        permutations(1, nboxes, new int[ritems], 0, ritems, "");
      }
}
