public class C2Q3 {

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

    static void deleteMiddle (Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        Node list = LLfromArray(input);
        deleteMiddle(list.next.next);
        System.out.println(list.toString());

    }

}
