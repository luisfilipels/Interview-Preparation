public class RemoveDupsFromSortedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp != null) {
                sb.append(temp.val + " ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        ListNode prev = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            if (tmp.next != null && tmp.next.val == tmp.val) {
                while (tmp.next != null && tmp.next.val == tmp.val) {
                    prev.next = tmp.next;
                    tmp = prev.next;
                }
                prev.next = tmp.next;
                tmp = prev.next;
            } else {
                prev = prev.next;
                tmp = tmp.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next = new ListNode(4);

        System.out.println(deleteDuplicates(head));
    }

}
