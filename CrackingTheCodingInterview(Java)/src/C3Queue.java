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
}
