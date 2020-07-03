package Extras.LeetCode;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static boolean hasCycle (ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while (hare != null) {
            if (hare.next == null) {
                return false;
            }
            hare = hare.next.next;
            tortoise = tortoise.next;
            if (hare == tortoise) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(2);
        //head.next.next = head;
        System.out.println(hasCycle(head));
    }

}
