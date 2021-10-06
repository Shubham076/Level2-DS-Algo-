/*
https://practice.geeksforgeeks.org/problems/maximum-difference/1
https://www.geeksforgeeks.org/find-maximum-difference-between-nearest-left-and-right-smaller-elements/
when we calculate next smaller element on the right just below the element in the stack we have next smaller
element on the left
*/
import java.util.*;
class maxDifferenceBetweenLeftAndRight{
    int findMaxDiff(int a[], int n) {
        Stack<Integer> s = new Stack<>();
        int ans = Integer.MIN_VALUE;
        s.push(0);
        for (int i = 1; i < a.length; i++) {
            while (s.size() > 0 && a[i] < a[s.peek()]) {
                int val = a[s.pop()];
                int nsr = a[i];

                //removing the duplicate values
                while (s.size() > 0 && a[s.peek()] == val) {
                    s.pop();
                }
                int nsl = s.size() > 0 ? a[s.peek()] : 0;
                int diff = Math.abs(nsr - nsl);
                ans = Math.max(ans, diff);
            }
            s.push(i);
        }

        while (s.size() > 0) {
            int nsr = 0;
            int val = a[s.pop()];
            //removing the duplicate values
            while (s.size() > 0 && a[s.peek()] == val) {
                s.pop();
            }
            int nsl = s.size() > 0 ? a[s.peek()] : 0;
            int diff = Math.abs(nsr - nsl);
            ans = Math.max(ans, diff);
        }
        return ans;
    }
	
}