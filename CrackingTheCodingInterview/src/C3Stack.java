public interface C3Stack {
    public class ArrayStack {
        private int head;
        private int [] stack;

        ArrayStack(){
            head = Integer.MIN_VALUE;
            stack = new int[1];
        }

        public boolean empty() {
            return head == Integer.MIN_VALUE;
        }

        public void append (int d) {
            if (head == stack.length - 1) {                     // If the stack represented by the array is full...
                int [] tempStack = new int[stack.length*2];     // Create a new stack with twice the size
                for (int i = 0; i < stack.length; i++) {        // Copy the values previously held in the stack to the new one
                    tempStack[i] = stack[i];
                }
                stack = tempStack;
            }
            if (head == Integer.MIN_VALUE) {                    // If the stack is empty
                stack[0] = d;
                head = 0;
            } else {
                head++;
                stack[head] = d;
            }
        }

        public void clear() {
            head = Integer.MIN_VALUE;
        }

        public int pop() {
            try {
                if (!(head == Integer.MIN_VALUE)) {                 // If the stack is not empty...
                    int returnInt = stack[head];                    // save the value currently held at the stack head
                    head--;
                    if (head == -1) {
                        head = Integer.MIN_VALUE;
                    }
                    return returnInt;
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                return Integer.MIN_VALUE;
            }
        }

        @Override
        public String toString() {
            if (head == Integer.MIN_VALUE) {
                return "null";
            }
            String returnString = "";
            for (int i = head; i >= 0; i--) {
                returnString += Integer.toString(stack[i]) + " ";
            }
            return returnString;
        }

        public String toString (String delim) {
            if (head == Integer.MIN_VALUE) {
                return "null";
            }
            String returnString = "";
            for (int i = head; i > 0; i--) {
                returnString += Integer.toString(stack[i]) + delim;
            }
            return returnString;
        }
    }

    public class LinkedListStack {
        public class Node {
            Node next = null;
            int data;

            public Node(int d) {
                data = d;
            }

            void appendToTail(int d) {
                this.next = new Node(d);
            }

            @Override
            public String toString() {
                return Integer.toString(data);
            }
        }

        private Node head = null;

        LinkedListStack () {}

        public LinkedListStack(int d) {
            head = new Node(d);
        }

        public int peek() {
            try {
                return head.data;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return Integer.MIN_VALUE;
            }
        }

        public void append(int d) {
            if (head == null) {
                head = new Node(d);
                return;
            }
            Node temp = new Node(d);
            temp.next = head;
            head = temp;
        }

        public int pop() {
            try {
                int returnValue = head.data;
                head = head.next;
                return returnValue;
            } catch (NullPointerException e) {
                e.printStackTrace();
                return Integer.MIN_VALUE;
            }
        }

        public void clear () {
            head = null;
        }

        public boolean empty () {
            return head == null;
        }

        @Override
        public String toString() {
            Node temp = head;
            String returnString = "";
            if (temp == null) {
                return "null";
            }
            while (temp != null) {
                returnString += temp.data + " ";
                temp = temp.next;
            }
            return returnString;
        }

        public String toString(String delim) {
            Node temp = head;
            String returnString = "";
            if (temp == null) {
                return "null";
            }
            while (temp != null) {
                returnString += temp.data + delim;
                temp = temp.next;
            }
            return returnString;
        }
    }
}