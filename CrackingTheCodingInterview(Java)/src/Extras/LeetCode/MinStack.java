package Extras.LeetCode;

import java.util.EmptyStackException;

public class MinStack {

    static class Node {
        int val;
        int min;
        Node next;

        Node (int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    static class MinStackInternal {

        Node top;

        /** initialize your data structure here. */
        public MinStackInternal() {
            top = null;
        }

        public void push(int x) {
            if (top == null) {
                top = new Node(x, x);
                return;
            }
            Node n = new Node(x, Math.min(x, top.min));
            n.next = top;
            top = n;
        }

        public void pop() {
            if (top == null) {
                return;
            }
            top = top.next;
        }

        public int top() {
            if (top == null) {
                return -1024;
            }
            return top.val;
        }

        public int getMin() {
            if (top == null) {
                return -1024;
            }
            return top.min;
        }
    }
    //                                                                                                                                                                                    i
    //["MinStack",        "push",        "push",      "push",       "top","pop","getMin","pop","getMin","pop",    "push",     "top",     "getMin",    "push",     "top","getMin","pop","getMin"]
    //[   [],          [2147483646],   [2147483646], [2147483647],    [],   [],    [],     [],     [],     [], [2147483647],    [],           [],  [-2147483648],   [],    [],     [],    []]
    public static void main(String[] args) {
        MinStackInternal minStack = new MinStackInternal();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}
