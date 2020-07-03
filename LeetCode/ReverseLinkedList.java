package Extras.LeetCode;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //Solution 1: Recursion, returning new Linked List
    /*static ListNode reverseList (ListNode head) {
        if (head == null) {
            return null;
        }
        helper(head);
        return newList;
    }

    static ListNode headPointer;
    static ListNode newList;

    static void helper (ListNode current) {
        if (current.next != null) {
            helper(current.next);
        } else {
            newList = new ListNode(current.val);
            headPointer = newList;
            return;
        }
        headPointer.next = new ListNode(current.val);
        headPointer = headPointer.next;
    }*/

    //Solution 2: Recursion
    static ListNode returnList = null;

    private static ListNode reverseList (ListNode head) {
        if (head == null) {
            return null;
        }
        helper(head, null);
        return returnList;
    }

    static private void helper (ListNode current, ListNode prev) {
        if (current.next == null) {
            returnList = current;
            returnList.next = prev;
        } else {
            ListNode next = current.next;
            current.next = prev;
            helper(next, current);
        }
    }



    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        ListNode newList = reverseList(root);
        System.out.println(newList.val);
    }

}
