import java.util.HashSet;

public class C2Q1 {

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
    }

    // O(n²) time solution, O(1) space.
    // For each node in the list, check for nodes with the same value in the nodes that come after the node head.
    public static void removeDups(Node head) {
        Node current = head;
        while (current.next != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.val == current.val) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    // O(n) time solution, O(n) space.
    // Go through the whole LL, inserting the value of each node into a hashset in case the value is not already in the
    // hashset. If it is in the hashset, point previous.next to temp.next, effectively removing the current (duplicate)
    // node from the LL.
    public static void removeDupsHash(Node head) {
        HashSet<Integer> hash = new HashSet<>();
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (hash.contains(temp.val)) {
                prev.next = temp.next;
            } else {
                hash.add(temp.val);
                prev = temp;
            }
            temp = temp.next;
        }
    }


    public static void main(String[] args) {

        Node head = new Node(3);
        head.append(2);
        head.append(2);
        head.append(2);
        head.append(2);
        head.append(2);
        head.append(1);
        head.append(2);
        head.append(2);
        removeDupsHash(head);
        System.out.println(head.toString());

    }

}
