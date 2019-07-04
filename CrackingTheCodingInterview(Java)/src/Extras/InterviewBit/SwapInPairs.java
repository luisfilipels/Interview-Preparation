package Extras.InterviewBit;

public class SwapInPairs {

    public static ListNode swapPairs (ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode prev = A;
        ListNode current = A.next;
        ListNode start = current;
        while (true) {
            ListNode next = current.next;
            current.next = prev;
            if (next == null || next.next == null) {
                prev.next = null;
                break;
            }
            prev.next = next.next;
            prev = next;
            current = prev.next;
        }
        return start;

    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A = swapPairs(A);
        ListNode temp = A;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
