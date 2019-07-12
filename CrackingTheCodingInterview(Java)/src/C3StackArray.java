public interface C3StackArray {
    public class Stack{
        private int head;
        private int [] stack;

        Stack (){
            head = Integer.MIN_VALUE;
            stack = new int[1];
        }

        public boolean empty() {
            return head == Integer.MIN_VALUE;
        }

        public void append (int d) {
            if (head == stack.length - 1) {
                int [] tempStack = new int[stack.length*2];
                for (int i = 0; i < stack.length; i++) {
                    tempStack[i] = stack[i];
                }
                stack = tempStack;
            }
            if (head == Integer.MIN_VALUE) {
                stack[0] = d;
                head = 0;
            } else {
                head++;
                stack[head] = d;
            }
        }

        public int pop() {
            try {
                if (!(head == Integer.MIN_VALUE)) {
                    int returnInt = stack[head];
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
}