public class RemoveLinkedListElements {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int val) {
            this.val = val;
        }
        ListNode(){}

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

    private static  ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode tmp = dummy;

        while (tmp.next != null) {
            while (tmp.next != null && tmp.next.val == val) {
                tmp.next = tmp.next.next;
            }
            if (tmp.next != null) tmp = tmp.next;
            else break;
        }
        tmp.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);*/
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next.next.next = new ListNode(3);

        System.out.println(removeElements(head, 3));
    }

}
