package Extras.InterviewBit;

public class PartitionList {

    public static class LinkedList {
        ListNode head;
        ListNode tail;

        public LinkedList() {}

        public LinkedList(int d) {
            head = new ListNode(d);
            tail = head;
        }

        public LinkedList(int [] array) {
            for (int i1 : array) {
                append(i1);
            }
        }

        public LinkedList (ListNode head) {
            ListNode temp = head;
            while (temp != null) {
                append(temp.val);
                temp = temp.next;
            }
        }

        public void append(int d) {
            if (head == null) {
                head = new ListNode(d);
                tail = head;
                return;
            }
            if (head == tail) {
                head.next = new ListNode(d);
                tail = head.next;
            } else {
                tail.next = new ListNode(d);
                tail = tail.next;
            }
        }
    }

    public static ListNode partition(ListNode A, int B) {
        if (A == null) {
            return null;
        } else if (A.next == null) {
            return A;
        }
        ListNode temp = A;
        LinkedList less = new LinkedList();
        LinkedList more = new LinkedList();
        while (temp.next != null) {
            if (temp.val < B) {
                less.append(temp.val);
            } else {
                more.append(temp.val);
            }
            temp = temp.next;
        }
        if (temp.val < B) {
            less.append(temp.val);
        } else {
            more.append(temp.val);
        }
        if (less.head == null) {
            return more.head;
        }
        if (more.head == null) {
            return less.head;
        }
        less.tail.next = more.head;
        return less.head;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList(new int[] {1, 2, 3, 4, 5});
        ListNode returnList = partition(a.head, 1);
        ListNode temp = returnList;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }


    }
}
