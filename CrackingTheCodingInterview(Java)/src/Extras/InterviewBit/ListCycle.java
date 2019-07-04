package Extras.InterviewBit;

public class ListCycle {

    public static ListNode detectCycle (ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while (fast != null) {
            try {
                fast = fast.next.next;
            } catch (NullPointerException e) {
                return null;
            }
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            try {
                fast = fast.next;
            } catch (Exception e) {
                return null;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(6);
        //A.next.next.next.next.next = A.next.next.next.next;
        A = detectCycle(A);
        try {
            System.out.println(A.val);
        } catch (NullPointerException e) {
            System.out.println("null");
        }

    }
}
