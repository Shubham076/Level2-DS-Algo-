
/*
You are given a two-dimensional list of integers coordinates where each element is in the form [x, y], representing a Euclidean coordinate.
Return the smallest eucliden distance between 2 points
coordinates = [
    [0, 0],
    [1, 1],
    [2, 4]
]
output = 2;
*/
import java.util.*;

public class shortestDistancebetween2Points {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getDistance(Point a, Point b) {
        int diff1 = b.x - a.x;
        int diff2 = b.y - a.y;
        double x = Math.pow(diff1, 2) + Math.pow(diff2, 2);
        return (int)(x);
    }

    public static int getDistance(List<Point> arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                Point a = arr.get(i);
                Point b = arr.get(j);
                min = Math.min(min, getDistance(a, b));
            }
        }
        return min;
    }
    // O(nlogn)
    public static int closestDistance(List<Point> x, List<Point> y) {
        int n = x.size();
        if (n <= 3) 
            return getDistance(x);

        int mid = n / 2;
        Point midPt = x.get(mid);
        List<Point> xl = new ArrayList<>();
        List<Point> xr = new ArrayList<>();
        List<Point> yl = new ArrayList<>();
        List<Point> yr = new ArrayList<>();

        for (int i = 0; i <= mid; i++) {
            xl.add(x.get(i));
        }

        for (int i = mid + 1; i < n; i++) {
            xr.add(x.get(i));
        }

        for(Point p: y){
            if(p.x <= midPt.x){
                yl.add(p);
            }
            else{
                yr.add(p);
            }
        }

        int dl = closestDistance(xl, yl);
        int dr = closestDistance(xr, yr);
        int del = Math.min(dl, dr);

        // adding all the point of y in the range of mid - del & mid + del
        List<Point> s = new ArrayList<>();
        for (int i = 0; i < y.size(); i++) {
            Point pt = y.get(i);
            int diff = Math.abs(pt.x - midPt.x);
            if (diff <= del) {
                s.add(pt);
            }
        }

        for (int i = 0; i < s.size(); i++) {
            //maximum seven points we need to check it is proved by geometry
            for (int j = 1; (i + j) < s.size() && j <= 7; j++) {
                del = Math.min(del, getDistance(s.get(i), s.get(i + j)));
            }
        }
        return del;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1}, {0 , 0}, {2, 4}};
        List<Point> x = new ArrayList<>();
        List<Point> y = new ArrayList<>();

        for (int[] a : arr) {
            Point p = new Point(a[0], a[1]);
            x.add(p);
            y.add(p);
        }

        Collections.sort(x, (a, b) -> a.x - b.x);
        Collections.sort(y, (a, b) -> a.y - b.y);
        // closestDistance(x, y);
        System.out.println(closestDistance(x, y));
    }
}
