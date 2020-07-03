package Design;

import java.util.Stack;

public class Q155_MinStack {

    private Stack<int[]> s;

    /** initialize your data structure here. */
    public Q155_MinStack() {
        s = new Stack<>();
        s.push(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE});
    }

    public void push(int x) {
        s.push(new int[]{x,Math.min(x,s.peek()[1])});
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek()[0];
    }

    public int getMin() {
        return s.peek()[1];
    }


}
