public class SwapNodesInPairs {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode node = this;
            while (node != null) {
                sb.append(node.val + " ");
                node = node.next;
            }
            return sb.toString();
        }
    }

    static public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode previous = new ListNode(-1); // Create a dummy node, allowing to keep a permanent reference to the first element of the LL, even if we swap it.
        previous.next = head;
        head = previous;

        ListNode first = head.next;

        ListNode second = first.next;
        if (second == null) return head;

        while (first.next != null) {
            ListNode next = second.next;    // Keep a reference to the first node of the next pair we're going to swap.

            // Swap the nodes
            previous.next = second;
            second.next = first;
            first.next = next;

            if (first.next == null || first.next.next == null) {
                return head.next;
            }

            // Preparation for the next pair
            previous = first;
            first = previous.next;
            second = first.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head =new ListNode(1);
        head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);*/

        head = swapPairs(head);

        System.out.println(head.toString());
    }



}
