public interface C2LinkedList {

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

    public class LinkedList {
        Node head = null;

        public int size() {
            Node temp = head;
            int i = 0;
            while (temp.next != null) {
                i++;
                temp = temp.next;
            }
            return i;
        }

        public LinkedList() {}

        public LinkedList(int [] array) {
            for (int i1 : array) {
                append(i1);
            }
        }

        public LinkedList(int d) {
            head = new Node(d);
        }

        public void append(int d) {
            if (head == null) {
                head = new Node(d);
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(d);
        }

        public Node remove (int index) {
            Node temp = head;
            if (index > size() || index < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (index == 0) {
                Node returnNode = head;
                head = head.next;
                return returnNode;
            }
            for (int i = 0; i < index || temp.next != null; i++) {
                if (i == index - 1) {
                    if (temp.next.next != null) {
                        Node returnNode = temp.next;
                        temp.next = temp.next.next;
                        return returnNode;
                    } else {
                        Node returnNode = temp.next;
                        temp.next = null;
                        return returnNode;
                    }
                }
                temp = temp.next;
            }
            return null;
        }

        public void appendNodeToTail (Node node) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        public Node deleteNode(int value) {
            if (head.data == value) {
                Node returnNode = head;
                head = head.next;
                return returnNode;
            }
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data == value) {
                    temp.next = temp.next.next;
                    return head;
                }
                temp = temp.next;
            }
            return head;
        }

        public void swapByIndex (int index1, int index2) {
            if (index1 < 0 || index2 < 0) {
                throw new IllegalArgumentException("Linked List Illegal Arguments: " + index1 + ", " + index2);
            }
            if (index1 > index2) {
                int temp = index1;
                index1 = index2;
                index2 = temp;
            }
            Node runner = head;
            Node prev1 = null, prev2 = null;
            Node node1 = null, node2 = null;
            int i = 0;
            for (i = 0; i < index2 || runner.next != null; i++) {
                if (i == index1 - 1) {
                    prev1 = runner;                                     // Get leftmost part of LL, right before element at index
                    node1 = new Node(runner.next.data);                 // Get element of index
                }
                if (i == index2 - 1) {
                    prev2 = runner;                                     // Same as above, but for second element
                    node2 = new Node(runner.next.data);
                    break;
                }
                runner = runner.next;
            }
            if (prev2 == null) {                                        // index2 is greater than the amount of elements
                throw new IndexOutOfBoundsException("Linked List arguments out of bounds for LL of size " + i);
            }
            boolean isStart = false;
            if (prev1 == null) {                                         // Taking care of edge case of when the first index refers to the first element
                prev1 = new Node(0);                                  // Temporary element
                node1 = new Node(head.data);
                prev1.next = head;
                head = prev1;
                isStart = true;
            }
            if (index2 - index1 == 1) {                                 // Edge case of adjacency
                prev1.next = node2;
                prev1.next.next = node1;
                prev1.next.next.next = prev2.next.next;
            } else {
                Node end = prev2.next.next;                                 // end = leftmost part of LL
                Node middle = prev1.next.next;                              // middle = elements between index1 and index2
                prev1.next = node2;
                node2.next = middle;
                prev2.next = node1;
                node1.next = end;
            }
            if (isStart) {
                head = head.next;                                       // Garbage collector gets rid of the temporary element
            }
        }

        public String toString(String delim) {
            StringBuilder s = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                s.append(temp.data);
                s.append(delim);
                temp = temp.next;
            }
            return s.toString();
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            Node temp = head;
            while (temp != null) {
                s.append(temp.data);
                s.append(" ");
                temp = temp.next;
            }
            return s.toString();
        }

    }

}
