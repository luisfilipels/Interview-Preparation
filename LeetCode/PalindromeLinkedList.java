package Extras.LeetCode;

public class PalindromeLinkedList {

    static private class ListNode {
        int val;
        ListNode next;
        ListNode (int x) { val = x; }
    }

    // O(n) time and O(1) space. (Reversing the list)
    private static boolean isPalindrome (ListNode head) {
        int size = 0;
        ListNode right = head;
        while (right != null) {
            size++;
            right = right.next;
        }
        if (size <= 1 ) {
            return true;
        } else if (size == 2) {
            return head.val == head.next.val;
        } else if (size == 3) {
            ListNode temp = head.next.next;
            return head.val == temp.val;
        }
        right = head.next;
        ListNode previous = head;
        for (int i = 0; i < (size / 2)-1; i++) {
            previous = previous.next;
            right = right.next;
        }
        if (size % 2 == 0) {
            previous.next = null;
        } else {
            previous.next = null;
            right = right.next;
        }
        previous = null;
        while (right != null) {
            ListNode next = right.next;
            right.next = previous;
            previous = right;
            right = next;
        }
        right = previous;
        ListNode left = head;
        while (right != null && left != null) {
            if (right.val != left.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //[1,3,2,4,3,2,1]

    public static void main(String[] args) {
        /*ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);*/
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }

}
