public class C3TestQueue {
    public static void main(String[] args) {
        C3Queue.ArrayQueue queue = new C3Queue.ArrayQueue();
        queue.enqueue(100);
        queue.enqueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(8);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(16);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(100);
        queue.enqueue(10);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        while (!queue.empty()) {
            System.out.println(queue.dequeue());
        }
        queue.enqueue(1);
        System.out.println(queue.toString());
    }
}
