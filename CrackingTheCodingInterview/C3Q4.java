import java.util.Stack;

public class C3Q4 {

    static class MyQueue {
        Stack<Integer> enqueueStack;
        Stack<Integer> dequeueStack;

        MyQueue () {
            enqueueStack = new Stack<>();
            dequeueStack = new Stack<>();
        }

        void enqueue (int d) {
            while (!dequeueStack.empty()) {
                enqueueStack.add(dequeueStack.pop());
            }
            enqueueStack.add(d);
        }

        int dequeue () {
           while (!enqueueStack.empty()) {
               dequeueStack.add(enqueueStack.pop());
           }
           return dequeueStack.pop();
        }

        boolean empty() {
            return dequeueStack.size() == 0 && enqueueStack.size() == 0;
        }

        int peek () {
            while (!enqueueStack.empty()) {
                dequeueStack.add(enqueueStack.pop());
            }
            return dequeueStack.peek();
        }

    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(2);
        queue.enqueue(1);
        while (!queue.empty()) {
            System.out.println(queue.dequeue());
        }
    }
}
