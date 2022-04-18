//lintcode 859
import java.util.*;
class MaxStack {
    Stack<Integer> s;
    Stack<Integer> max;
    public MaxStack() {
        s = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        if (s.size() == 0) {
            max.push(x);
        } else {
            int v = Math.max(x, max.peek());
            max.push(v);
        }
        s.push(x);
    }

    public int pop() {
        if (s.size() == 0) {
            return -1;
        } else {
            max.pop();
            return s.pop();
        }
    }

    public int top() {
        if (s.size() == 0) {
            return -1;
        } else {
            return s.peek();
        }
    }
    public int peekMax() {
        if (max.size() == 0) {
            return -1;
        } else {
            return max.peek();
        }
    }

//o(n)
    public int popMax() {
        int tbr = max.peek(); //to be removed
        Stack<Integer> buffer = new Stack<>();
        while (s.peek() != tbr) {
            buffer.push(pop());
        }

        // element popped from the main stack
        pop();

        //put the elements back in the stack
        while (buffer.size() > 0) {
            push(buffer.pop());
        }
        return tbr;
    }
    public static void main(String[] args) {
        MaxStack ms = new MaxStack();
        ms.push(1);
        ms.push(3);
        ms.push(2);
        ms.popMax();
    }
}