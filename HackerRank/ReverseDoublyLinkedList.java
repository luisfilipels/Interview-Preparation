package Extras.HackerRank;

public class ReverseDoublyLinkedList {

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            DoublyLinkedListNode temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.data).append(" ");
                temp = temp.next;
            }
            return sb.toString();
        }
    }

    static DoublyLinkedListNode reverse (DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        while (temp != null) {
            DoublyLinkedListNode next = temp.next;
            DoublyLinkedListNode prev = temp.prev;
            temp.next = prev;
            temp.prev = next;
            temp = temp.prev;
        }
        temp = head;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        return temp;
    }

    public static void main(String[] args) {
        DoublyLinkedListNode head = new DoublyLinkedListNode(1);
        head.next = new DoublyLinkedListNode(2);
        head.next.prev = head;
        head.next.next = new DoublyLinkedListNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DoublyLinkedListNode(4);
        head.next.next.next.prev = head.next.next;
        System.out.println(reverse(head));
    }

}
