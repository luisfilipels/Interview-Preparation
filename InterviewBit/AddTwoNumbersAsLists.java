package Extras.InterviewBit;

public class AddTwoNumbersAsLists {

    public void append (int d, ListNode head) {
        if (head == null) {
            head = new ListNode(d);
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(d);
    }
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        long size1 = 0;
        long size2 = 0;
        long num1 = 0;
        long num2 = 0;
        ListNode temp = A;
        while (temp.next != null) {
            size1++;
            temp = temp.next;
        }
        temp = A;
        for (int i = 0; i <= size1; i++) {
            num1 += temp.val * Math.pow(10, i);
            temp = temp.next;
        }
        temp = B;
        while (temp.next != null) {
            size2++;
            temp = temp.next;
        }
        temp = B;
        for (int i = 0; i <= size2; i++) {
            num2 += temp.val * Math.pow(10, i);
            temp = temp.next;
        }
        num1 += num2;
        ListNode head = new ListNode((int) num1 % 10);
        num1 /= 10;
        while (num1 > 1) {
            append((int) num1 % 10, head);
            num1 /= 10;
        }
        return head;

    }
}
