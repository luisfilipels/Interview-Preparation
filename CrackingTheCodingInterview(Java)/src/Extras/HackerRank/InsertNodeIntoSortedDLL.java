package Extras.HackerRank;

public class InsertNodeIntoSortedDLL {

    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode sortedInsert (DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (head == null) {
            return newNode;
        } else if (head.data >= newNode.data) {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        } else {
            DoublyLinkedListNode temp = head;
            while (temp.next != null && temp.next.data < newNode.data) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            if (temp.next != null) {
                newNode.next.prev = newNode;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
        return head;
    }

    public static void main(String[] args) {

    }

}
