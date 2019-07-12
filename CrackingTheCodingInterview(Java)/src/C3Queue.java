public interface C3Queue {
    public class ArrayQueue {
        public int front, back; // Front: Removals.          Back: Insertions.
        public int [] queue = new int[1];

        public ArrayQueue () {
            front = back = -1;
        }

        public void append (int d) {
            if (front == back && front == -1) {
                back = front = 0;
                queue[back] = d;
                return;
            }
            if (back == queue.length - 1) {
                
            }
        }
    }
}
