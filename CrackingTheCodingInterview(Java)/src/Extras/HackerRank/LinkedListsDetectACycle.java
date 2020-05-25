package Extras.HackerRank;

public class LinkedListsDetectACycle {

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle (Node head) {
        Node fast = head, slow = head;

        if (fast == null) return false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
