package Extras.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class CpyListWthRandPointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        Node (int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static Node copyRandomList (Node head) {
        if (head == null) return null;

        Node current = head;
        HashMap<Node, Node> hash = new HashMap<>();

        while (current != null) {
            Node newNode = new Node(current.val);
            hash.put(current, newNode);
            current = current.next;
        }

        current = head;
        while (current != null) {
            hash.get(current).next = hash.get(current.next);
            hash.get(current).random = hash.get(current.random);
            current = current.next;
        }

        return hash.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        Node newNode = copyRandomList(head);
        System.out.println(newNode.val);
    }

}
