import java.util.HashMap;
import java.util.Stack;

public class C2Q5 {

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

    // Easier case. As the least significant digit is the first element in each LL, we can simply go through each element
    // and sum them up as we go, not forgetting that we also need to take the carry into account while doing so.
    static Node sumListsCase1(Node h1, Node h2) {
        Node r1 = h1;
        Node r2 = h2;
        Node returnNode = new Node(-1);
        Node returnRunner = returnNode;

        int carry = 0;
        while (r1 != null || r2 != null) {
            int val;
            if (r1 != null && r2 != null) {
                val = r1.val + r2.val + carry;
            } else if (r1 == null) {
                val = r2.val + carry;
            } else {
                val = r1.val + carry;
            }
            carry = 0;
            if (val >= 10) {
                carry = 1;
                val -= 10;
            }
            returnRunner.next = new Node(val);
            returnRunner = returnRunner.next;
            if (r1 != null) {
                r1 = r1.next;
            }
            if (r2 != null) {
                r2 = r2.next;
            }
        }
        if (carry == 1) {
            returnRunner.next = new Node(1);
        }

        return returnNode.next;
    }

    // In this case, I decided to, instead of using recursion, using a stack.
    // If the two LL's sizes are the same, go through each LL and insert each node of each list into a stack. Once that is
    // done, pop each element from the stack, add the two Nodes that were popped, and move the carry into the next iteration. Finally, reverse the LL.
    // If the sizes are different, do what was done when the sizes were equal, but before doing so, add (size1 - size2) dummy nodes with 0 value into the stack.
    static Node sumListsCase2 (Node h1, Node h2) {
        int size1 = getSize(h1);
        int size2 = getSize(h2);

        Node returnNode = new Node(-1);
        Node returnRunner = returnNode;

        if (size1 == size2) {
            Stack<NodeTuple> stack = new Stack<>();
            Node t1 = h1;
            Node t2 = h2;
            return doSum(returnNode, returnRunner, stack, t1, t2);
        } else {
            int dif;
            if (size1 < size2) {
                Node temp = h1;
                h1 = h2;
                h2 = temp;
                dif = size2 - size1;
            } else {
                dif = size1 - size2;
            }
            Stack<NodeTuple> stack = new Stack<>();
            Node t1 = h1;
            Node t2 = h2;
            for (int i = 0; i < dif; i++) {
                stack.push(new NodeTuple(t1, new Node(0)));
                t1 = t1.next;
            }
            return doSum(returnNode, returnRunner, stack, t1, t2);
        }
    }

    static class NodeTuple {
        Node n1, n2;

        NodeTuple(Node n1, Node n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    static Node reverseList (Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            if (next == null) {
                break;
            }
            temp = next;
        }
        return temp;
    }

    private static Node doSum(Node returnNode, Node returnRunner, Stack<NodeTuple> stack, Node t1, Node t2) {
        while (t1 != null) {
            stack.push(new NodeTuple(t1, t2));
            t1 = t1.next;
            t2 = t2.next;
        }
        int carry = 0;
        while (!stack.isEmpty()) {
            NodeTuple current = stack.pop();
            Node n1 = current.n1;
            Node n2 = current.n2;

            int sum = n1.val + n2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            }
            returnRunner.next = new Node(sum);
            returnRunner = returnRunner.next;
        }
        if (carry == 1) {
            returnRunner.next = new Node(1);
        }
        return reverseList(returnNode.next);
    }

    static int getSize(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static void main(String[] args) {
        int [] input1  = {5, 0, 5};
        int [] input2 = {5, 0, 0};
        Node list1 = LLfromArray(input1);
        Node list2 = LLfromArray(input2);
        System.out.println(sumListsCase2(list1, list2).toString());
    }
}
