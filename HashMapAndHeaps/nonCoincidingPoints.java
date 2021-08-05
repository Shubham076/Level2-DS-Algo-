/*
https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1
condition when manhatten distance becomes equal to euclidean distance
|x2 - x1| + |y2 - y1| = sqrt((x2 - x1) ^ 2 + (y2 - y1) ^ 2);

on simplying we get
|x2 - x1| * |y2 - h2| = 0
means x2 = x1
or y2 = y1
or x1 == x2 && y1 == y2 (coinciding points)

algorithm
create three hashmap
m1 store frequency of x
m2 store frequency of y
m3 store frequency of (x, y) point as a whole
cnt = 0;
for each point we check if that x or y coordinate we have encoutered or not
we can easily check with m1 & m2

cnt += freq of x
cnt += freq of y

for removing duplicate we check if same coordinate we have encountered or not
this we can check in m3
cnt -= 2* freq(point) 
why multiply by 2 because if duplicate pair exist we must cnt 2 times one for x and 1 for y   
*/
import java.util.*;
public class nonCoincidingPoints {
    static int numOfPairs(int[] X, int[] Y, int N) {
        HashMap<Integer, Integer> x = new HashMap<>();
        HashMap<Integer, Integer> y = new HashMap<>();
        HashMap<String, Integer> pt = new HashMap<>();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int a = X[i];
            int b = Y[i];
            String p = a + "*" + b;
            cnt += x.getOrDefault(a, 0);
            cnt += y.getOrDefault(b, 0);
            cnt -= 2 * pt.getOrDefault(p, 0);

            x.put(a, x.getOrDefault(a, 0) + 1);
            y.put(b, y.getOrDefault(b, 0) + 1);
            pt.put(p, pt.getOrDefault(p, 0) + 1);
        }

        return cnt;
    }
}
