import java.util.HashSet;

public class C2Q8 {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        void append(int val) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }

        void append(Node node) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    static Node LLfromArray(int[] arr) {
        Node head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.append(arr[i]);
        }
        return head;
    }

    // Trivial implementation is with a hash table.
    static Node findLoopHash (Node head) {
        HashSet<Node> hashSet = new HashSet<>();
        Node temp = head;
        while (temp != null) {
            if (!hashSet.contains(temp)) {
                hashSet.add(temp);
            } else {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Optimal solution is with FLoyd's Algorithm
    static Node findLoop (Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = LLfromArray(new int[] {1, 2, 3, 4, 5, 6});
        head.append(head.next.next.next);
        try {
            System.out.println(findLoop(head).val);
        } catch (NullPointerException e) {
            System.out.println("null");
        }
    }
}
