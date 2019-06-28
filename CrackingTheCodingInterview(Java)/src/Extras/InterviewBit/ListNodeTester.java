package Extras.InterviewBit;

public class ListNodeTester {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        AddTwoNumbersAsLists add = new AddTwoNumbersAsLists();
        add.addTwoNumbers(list1, list2);
    }
}
