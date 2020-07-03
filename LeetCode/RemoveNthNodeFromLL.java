package Extras.LeetCode;

public class RemoveNthNodeFromLL {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode temp = this;
            while (temp != null) {
                sb.append(temp.val);
                sb.append("->");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    private static ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode back = head, front = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
            if (front == null) {
                return head.next;
            }
        }
        while (front.next != null) {
            front = front.next;
            back = back.next;
        }
        if (back.next.next == null) {
            back.next = null;
            return head;
        }
        back.next = back.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        System.out.println(removeNthFromEnd(root, 4));

    }

}
