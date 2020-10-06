import Extras.LeetCode.ReverseLinkedList;

import java.util.Stack;

public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

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

    // Not a valid solution (doesn't solve in one pass)
    /*static public ListNode reverseBetween (ListNode head, int m, int n) {
        int currentIndex = 0;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = dummy;
        ListNode start = null, end = null;

        Stack<ListNode> stack = new Stack<>();

        while (current != null) {
            if (currentIndex + 1 == m) start = current;
            if (currentIndex >= m && currentIndex <= n) {
                stack.push(current);
            } else if (currentIndex == n + 1) {
                end = current;
                break;
            }
            current = current.next;
            currentIndex++;
        }

        while (!stack.isEmpty()) {
            current = stack.pop();
            start.next = current;
            start = start.next;
        }
        start.next = end;

        return dummy.next;
    }*/

    static public ListNode reverseBetween (ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;

        int currentIdx = 1;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode cur = head, prev = dummy;

        while (currentIdx < m) {
            prev = prev.next;
            cur = cur.next;
            currentIdx++;
        }
        ListNode next = null;
        if (m + 1 == n) {
            next = cur.next;
            prev.next = next;
            ListNode bkp = next.next;
            next.next = cur;
            cur.next = bkp;
        } else {
            ListNode start = prev;
            ListNode newEnd = cur;
            prev = prev.next;
            cur = cur.next;
            currentIdx++;

            next = null;
            do {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                currentIdx++;
            } while (currentIdx < n);

            if (next != null) {
                next = next.next;
            }

            cur.next = prev;
            start.next = cur;
            newEnd.next = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        //root.next.next.next.next = new ListNode(5);

        root = reverseBetween(root, 2, 4);
        System.out.println(root);
    }

}
