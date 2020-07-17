import java.util.EmptyStackException;
import java.util.Stack;

public class C3Q4 {

    public static class MyQueue {
        Stack<Integer> enqueueStack = new Stack<>();
        Stack<Integer> dequeueStack = new Stack<>();

        void enqueue(int x) {
            while (!dequeueStack.isEmpty()) {
                enqueueStack.push(dequeueStack.pop());
            }
            enqueueStack.push(x);
        }

        int dequeue() {
            if (enqueueStack.isEmpty() && dequeueStack.isEmpty()) {
                throw new EmptyStackException();
            } else {
                while (!enqueueStack.isEmpty()) {
                    dequeueStack.push(enqueueStack.pop());
                }
                return dequeueStack.pop();
            }
        }

        boolean isEmpty() {
            return enqueueStack.isEmpty() && dequeueStack.isEmpty();
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
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
