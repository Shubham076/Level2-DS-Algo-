//leetcode 155
import java.io.*;
import java.util.*;

public class minStack {
    Stack<Long> data;
    long min;
    
    /** initialize your data structure here. */
    public minStack() {
        data = new Stack<>();

    }

    public void push(int val) {
        long v = (int)val;
        if (data.size() == 0) {
            data.push(0L);
            min = v;
        }
         else {
            long temp = v - min;
            data.push(temp);
            if (v < min) {
                min = v;
            }
        }
    }

    public void pop() {
        if (data.size() == 0) {
            return;
        }
        long temp = data.pop();
        if (temp < 0) {
            //in this case min is the original val
            //we have put val - 2nd min in  the stack
            //2nd min = val - temp;
            min = min - temp;
            return;
        }
        else {
            return;
        }
    }

    public int top() {
        if (data.size() == 0) {
            return -1;
        }
        long temp = data.peek();
        if (temp < 0) {
            return (int)min;

        }
        else {
            return (int)(temp + min);
        }
    }

    public int getMin() {
        if (data.size() == 0) {
            return -1;
        }
        else
            return (int)min;
    }
}