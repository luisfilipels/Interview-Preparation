import java.util.HashSet;

public class C2Q7 {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            Node temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val).append(" ");
                temp = temp.next;
            }
            return sb.toString();
        }

        void append(int val) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }

        void append (Node node) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    static Node LLfromArray(int[] arr) {
        Node head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.append(arr[i]);
        }
        return head;
    }

    // This question can also be done using a HashSet, but this approach uses O(1) space and O(n + m) time.
    // First, calculate the sizes of each LL. Consider the following example:
    /*
        h1 = 1 -> 2 -> 3
                        \
                         |-> 4 -> 5
                        /
                  h2 = 1
     */
    // h1 has size 5, while h2 has size 3. We first create two runner pointers pointing to each LL's head. We then move
    // the pointer of the largest LL (size(h1) - size(h2)) positions forward. At this point, both pointers are in sync.
    // After this, we can simply move both pointers forward at the same time and compare both until we either reach null
    // (no intersection), or find both pointers pointing to the same object.
    
    static Node findIntersect (Node h1, Node h2) {
        int size1 = 0, size2 = 0;

        Node temp = h1;
        while (temp != null) {
            size1++;
            temp = temp.next;
        }

        temp = h2;
        while (temp != null) {
            size2++;
            temp = temp.next;
        }

        int dif;
        if (size1 < size2) {
            temp = h1;
            h1 = h2;
            h2 = temp;
            dif = size2 - size1;
        } else {
            dif = size1 - size2;
        }

        temp = h1;
        Node temp2 = h2;

        for (int i = 0; i < dif; i++) {
            temp = temp.next;
        }
        while (temp != null) {
            if (temp == temp2) {
                return temp;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int [] input1 = new int[] {1, 2, 3, 4, 5};
        int [] input2 = new int[] {1, 2, 3};
        Node h1 = LLfromArray(input1);
        Node h2 = LLfromArray(input2);

        h2.append(h1.next.next.next);

        System.out.println(findIntersect(h1, h2).val);
    }
}
