package Extras.InterviewBit;

public class RotateList {

    public static ListNode rotateRight (ListNode A, int B) {
        ListNode temp = A;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size <= 1) {
            return A;
        }
        temp = A;
        B = B % size;
        for (int i = 0; i < size - B - 1; i++) {
            temp = temp.next;
        }
        ListNode start = temp.next;
        temp.next = null;
        temp = start;
        try {
            while (temp.next != null) {
                temp = temp.next;
            }
        } catch (Exception E) {
            return A;
        }
        ListNode end = temp;
        end.next = A;
        return start;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(68);
        A.next = new ListNode(86);
        A.next.next = new ListNode(36);
        A.next.next.next = new ListNode(16);
        A.next.next.next.next = new ListNode(5);
        A.next.next.next.next.next = new ListNode(75);
        /*ListNode A = new ListNode(91);
        A.next = new ListNode(34);
        A.next.next = new ListNode(18);
        A.next.next.next = new ListNode(83);
        A.next.next.next.next = new ListNode(38);
        A.next.next.next.next.next = new ListNode(82);
        A.next.next.next.next.next.next = new ListNode(21);
        A.next.next.next.next.next.next.next = new ListNode(69);*/

        //ListNode A = new ListNode(1);
        //A.next = new ListNode(2);
        //A.next.next = new ListNode(3);
        //A.next.next.next = new ListNode(4);
        //A.next.next.next.next = new ListNode(5);
        A = rotateRight(A, 90);
        ListNode temp = A;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
