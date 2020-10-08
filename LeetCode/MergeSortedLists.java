package Extras.LeetCode;

public class MergeSortedLists {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }

        ListNode() {}

        @Override
        public String toString() {
            ListNode temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val);
                sb.append(" -> ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    static private ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode handler = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                handler.next = l1;
                l1 = l1.next;
            } else {
                handler.next = l2;
                l2 = l2.next;
            }
            handler = handler.next;
        }
        if (l1 != null) {
            handler.next = l1;
        } else if (l2 != null) {
            handler.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(z4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);*/
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);
        l2.next.next.next = new ListNode(5);
        l2.next.next.next.next = new ListNode(6);
        l2.next.next.next.next.next = new ListNode(7);
        l2.next.next.next.next.next.next = new ListNode(8);
        ListNode newListNode = mergeTwoLists(l1, l2);
        while (newListNode != null) {
            System.out.println(newListNode.val);
            newListNode = newListNode.next;
        }

    }

}
