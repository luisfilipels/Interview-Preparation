public interface C3Queue {
    public class ArrayQueue {
        public int front, back; // Front: Removals, left.          Back: Insertions, right.
        public int [] queue = new int[1];

        public ArrayQueue () {
            front = back = -1;
        }

        public void enqueue(int d) {
            if (front == back) {                // If the queue is empty...
                back = 0;                       // create a new value in the queue
                queue[back] = d;
                return;
            }
            if (back == queue.length - 1) {                     // If the queue is full
                int [] tempQueue = new int[queue.length * 2];   // Create a new queue with twice the previous size
                int j = 0, i = 0;
                for (i = front + 1; i <= back; i++) {           // Copy the previous values
                    tempQueue[j] = queue[i];
                    j++;
                }
                front = -1;                                     // To save space, move front to -1
                back = i;
                queue = tempQueue;
                queue[back] = d;
                return;
            }
            queue[++back] = d;
        }

        public int dequeue () {
            if (front - 1 == back) {
                front = -1;
                back = 0;
                return Integer.MIN_VALUE;
            } else if (front > back) {
                System.out.println("Something went very wrong! Make an exception here later!");
                return Integer.MIN_VALUE;
            }
            int returnInt = queue[++front];
            if (front == back) {
                front = -1;
                back = -1;
            }
            return returnInt;
        }

        public boolean empty () {
            return front == back;
        }

        public String toString(String delim) {
            String returnString = "";
            if (front == back || front - 1 == back) {
                return "null";
            }
            for (int i = front + 1; i <= back; i++) {
                returnString += queue[i] + delim;
            }
            return returnString;
        }

        @Override
        public String toString() {
            String returnString = "";
            if (front == back || front - 1 == back) {
                return "null";
            }
            for (int i = front + 1; i <= back; i++) {
                returnString += queue[i] + " ";
            }
            return returnString;
        }
    }

    public class LinkedListQueue {

        public class Node {
            Node next = null;
            int data;

            public Node(int d) {
                data = d;
            }

            void appendToTail(int d) {
                this.next = new Node(d);
            }

            @Override
            public String toString() {
                return Integer.toString(data);
            }
        }

        Node front, back;

        LinkedListQueue () {
            front = null;
            back = null;
        }

        public void enqueue (int d) {
            Node newNode = new Node(d);
            if (front == back && front == null) {               // If this is the first node
                front = newNode;
                back = newNode;
                return;
            }
            back.next = newNode;
            back = back.next;
        }

        public int dequeue() {
            if (front == back && front == null) {               // If there were no nodes
                front = null;
                back = null;
                return Integer.MIN_VALUE;
            }
            if (front == back) {                                // If, after deletion, there will be no nodes...
                int returnInt = front.data;
                front = null;
                back = null;
                return returnInt;
            }
            int returnInt = front.data;
            front = front.next;
            return returnInt;
        }

        public boolean empty() {
            return front == back && back == null;
        }

        @Override
        public String toString() {
            Node temp = front;
            String returnString = "";
            while (temp != null) {
                returnString += temp.data + " ";
                temp = temp.next;
            }
            return returnString;
        }
    }
}
