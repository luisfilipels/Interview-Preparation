package Extras.InterviewBit;

public class SwapInPairs {

    public static ListNode swapPairs (ListNode A) {
        ListNode current = A;
        ListNode next;
        boolean startSet = false;
        ListNode start = null;
        while (current != null && current.next != null) {
            try {
                if (!startSet) {
                    start = current.next;
                    startSet = true;
                }
                next = current.next.next;
                current.next.next = current;
                current.next = next;
            } catch (Exception e){
                break;
            }
            current = next;
        }
        return start;
    }

    public static void main(String[] args) {

    }
}
