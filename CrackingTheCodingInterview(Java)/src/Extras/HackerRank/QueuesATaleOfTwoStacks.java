package Extras.HackerRank;

import java.util.Stack;

public class QueuesATaleOfTwoStacks {

    static class MyQueue<T> {

        Stack<T> stack = new Stack<>();
        Stack<T> helper = new Stack<>();

        void enqueue (T x) {
            stack.push(x);
        }

        void dequeue() {
            if (helper.isEmpty()) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
            }
            helper.pop();
        }

        T peek() {
            if (helper.isEmpty()) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
            }
            return helper.peek();
        }
    }

    // First solution. TLE.
    /*static class MyQueue<T> {
        T front = null;

        Stack<T> stack = new Stack<>();
        Stack<T> helper = new Stack<>();

        enum LastOperation {
            ENQUEUE, DEQUEUE
        }

        LastOperation last = LastOperation.ENQUEUE;

        void enqueue (T x) {
            if (front == null || stack.isEmpty()) {
                front = x;
            }
            if (last == LastOperation.ENQUEUE) {
                stack.push(x);
            } else {
                if (!helper.isEmpty()) {
                    front = helper.peek();
                }
                while (!helper.isEmpty()) {
                    stack.push(helper.pop());
                }
                stack.push(x);
            }
            last = LastOperation.ENQUEUE;
        }

        void dequeue() {
            if (last == LastOperation.ENQUEUE) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
                helper.pop();
            } else {
                helper.pop();
            }
            if (!helper.isEmpty()) {
                front = helper.peek();
            }
            last = LastOperation.DEQUEUE;
        }

        T peek() {
            return front;
        }
    }*/

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
    }

}
