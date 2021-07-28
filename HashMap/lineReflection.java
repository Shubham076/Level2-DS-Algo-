/*
lintcode 908
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

we know that leftmost point is the mirror reflection of righmost point
so if a mirror or y axis axis that reflect all the points that is should be (xmin + xmax) / 2;
therefore we only need to check (xmin + xmax) / 2

here we are storing the point in the form of hash why string operations are costly can give tle coz of costraints
algorithm:
* with the help of xmin and xmax we have find x coordinate the potential mirror
* now for each point we verify if its mirror image exist or not
xmirr = x1 + x2 / 2;
x2 = 2 * xmirr - x1;
*/
import java.util.*;
public class lineReflection {
    public boolean isReflected(int[][] points) {
        long xmin = Long.MAX_VALUE;
        long xmax = Long.MIN_VALUE;
        HashSet<Long> set = new HashSet<>();
        for(int[] p : points){
            long x = p[0];
            long y = p[1];
            xmin = Math.min(xmin, x);
            xmax = Math.max(xmax, x);
            long key = x * 10_00_00_001 + y;  //representing the point
            set.add(key);
        }

        long mirr = xmin + xmax;
        for(int[] p : points){
            long x1 = p[0];
            long y = p[1];
            long hash1 = x1 * 10_00_00_001 + y;
            if(!set.contains(hash1)){
                continue;
            }
            if(x1 + x1 == mirr){
                //means mirror image lies on the mirror itself => means point is present in mirror itself
                set.remove(hash1);
                continue;
            }

            /*
            now 2 * mirr = x1 + x2
            x2 = 2 * mirr - x1
            */
            long x2 = mirr - x1;
            long hash2 = x2 * 10_00_00_001 + y;
            if(set.contains(hash2)){
                //mirror image found
                set.remove(hash1);
                set.remove(hash2);
            }
            else{
                return false;
            }
        }
        return true;
    }    
}
