public class OddEvenLinkedList {

    private static class ListNode {
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

    private static ListNode oddEvenList (ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        ListNode tmp = head.next;
        ListNode prev = head;

        ListNode middle = null;

        int count = 1;
        while (tmp != null) {
            if (tmp == middle) break;
            if (count % 2 == 0) {
                prev.next = tmp.next;
                tail.next = tmp;
                tail = tail.next;
                tmp.next = null;
                tmp = prev.next;
                if (middle == null) middle = tail;
            } else {
                prev = tmp;
                tmp = tmp.next;
            }
            count++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);

        /*ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);*/

        System.out.println(oddEvenList(head));
    }

}
