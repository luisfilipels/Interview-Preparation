package Extras.InterviewBit;

public class RemoveDuplicatesFromSorted {

    public static ListNode removeDups(ListNode A) {
        ListNode current = A;
        try {
            while (current.next != null) {
                ListNode runner = current;
                while (runner.next != null) {
                    if (runner.next.val == current.val) {
                        runner.next = runner.next.next;
                    } else {
                        runner = runner.next;
                    }
                }
                current = current.next;
            }
        } catch (NullPointerException ignored) {}

        return A;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.next = new ListNode(1);
        A.next.next = new ListNode(2);
        A.next.next.next = new ListNode(3);
        A.next.next.next.next = new ListNode(3);
        ListNode temp = A;
        removeDups(A);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
