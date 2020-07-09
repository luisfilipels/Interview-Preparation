import java.util.Stack;

public class C2Q6 {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            Node temp = this;
            StringBuilder sb = new StringBuilder();
            while (temp != null) {
                sb.append(temp.val).append(" ");
                temp = temp.next;
            }
            return sb.toString();
        }

        void append(int val) {
            Node temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
    }

    static Node LLfromArray(int[] arr) {
        Node head = new Node(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            head.append(arr[i]);
        }
        return head;
    }

    public static boolean isPalindrome (Node head) {
        Stack<Node> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (!stack.isEmpty()) {
            if (stack.pop().val != temp.val) return false;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int [] input = new int[] {1, 2, 3, 2, 1, 2, 1};
        Node head = LLfromArray(input);
        System.out.println(isPalindrome(head));
    }
}
