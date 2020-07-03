import java.util.Stack;

public class C2Q6 {

    public static void reverseList (C2LinkedList.LinkedList list) {
        C2LinkedList.Node prev = null;
        C2LinkedList.Node current = list.head;
        C2LinkedList.Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
    }

    public static boolean isPalindrome (C2LinkedList.LinkedList list) {
        C2LinkedList.LinkedList newList = new C2LinkedList.LinkedList();
        C2LinkedList.Node temp = list.head;
        while (temp != null) {
            newList.append(temp.data);
            temp = temp.next;
        }
        reverseList(newList);
        C2LinkedList.Node node1 = list.head;
        C2LinkedList.Node node2 = newList.head;
        while (node1 != null) {
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;

    }

    public static void main(String[] args) {
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList(new int[]{1, 2, 3, 2, 1, 1});
        System.out.println(isPalindrome(list));
    }
}
