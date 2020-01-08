package Extras.LeetCode;

public class LinkedListCycleII {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean foundCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                foundCycle = true;
                break;
            }
        }
        if (!foundCycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }

}
