package Extras.HackerRank;

public class InsertNodeAtSpecificPositionInLL {

    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition (SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(-1);
        dummy.next = head;
        SinglyLinkedListNode temp = dummy;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            temp.next = new SinglyLinkedListNode(data);
        } else {
            SinglyLinkedListNode help = temp.next;
            temp.next = new SinglyLinkedListNode(data);
            temp.next.next = help;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
