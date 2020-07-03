public class C2Q8 {

    // Trivial implementation with a hash table.

    public static C2LinkedList.Node findLoop (C2LinkedList.LinkedList list) {
        C2LinkedList.Node slow = list.head;
        C2LinkedList.Node fast = list.head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = list.head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        C2LinkedList.LinkedList list = new C2LinkedList.LinkedList(new int[] {1, 2, 3, 4});
        //list.head.next.next.next.next = list.head.next;
        try {
            System.out.println(findLoop(list).data);
        } catch (NullPointerException e) {
            System.out.println("null");
        }
    }
}
