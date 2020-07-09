public class C2Q4 {

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

    static Node partition (Node head, int x) {
        Node lessRoot = new Node(-1);
        Node geqRoot = new Node(-1);
        Node lessRunner = lessRoot;
        Node geqRunner = geqRoot;

        Node temp = head;
        while (temp != null) {
            Node bkp = temp.next;
            temp.next = null;
            if (temp.val < x) {
                lessRunner.next = temp;
                lessRunner = lessRunner.next;
            } else {
                geqRunner.next = temp;
                geqRunner = geqRunner.next;
            }
            temp = bkp;
        }
        lessRunner.next = geqRoot.next;
        return lessRoot.next;
    }

    public static void main(String[] args) {
        int [] input = {3, 5, 8, 5, 10, 2, 1};
        Node list = LLfromArray(input);
        list = partition(list, 2);
        System.out.println(list.toString());
    }
}
