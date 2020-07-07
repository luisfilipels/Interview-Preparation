public class C2Q2 {

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

    static Node LLfromArray(int[] arr) {
        Node head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.append(arr[i]);
        }
        return head;
    }

    // Approach 1, using two pointers. O(n) time, O(1) space.
    // Use two pointers, last and first. Move first forward k times. After this, move last and first forward at the same
    // time, until first is null. When this is done, last will be the node that is the Kth to last.
    static Node kthToLast (Node head, int k) {
        Node last = head;
        Node first = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        return last;
    }

    // Approach 2, counting the number of nodes. O(n) time, O(1) space.
    // First, count the number of elements in the LL. Logically, if there are n elements in the LL, the kTh to last element
    // will be the n - k element of the LL, counting from the head node.
    static Node kthToLast2 (Node head, int k) {
        int n = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            n++;
        }
        temp = head;
        for (int i = 0; i < n - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        Node head = LLfromArray(input);
        System.out.println(kthToLast2(head, 1).val);

    }
}
