import java.util.Stack;

public class C3Q2 {
    /*
        From the back of my head, I'd keep an auxiliary stack. Every time I push a new element into the main stack, I'd
        check if this new element is less than the top of my auxiliary stack. If so, I push a reference to the new element
        into the auxiliary stack. If I pop an element from the main stack, I'll check if the element that's being popped
        from the main stack is the same as the one I keep on the top of the auxiliary stack. If so, I'll pop it as well.
     */

    public static class Question2Stack {

        Stack<Integer> mainStack;
        Stack<Integer> auxStack;

        Question2Stack () {
            mainStack = new Stack<>();
            auxStack = new Stack<>();
        }

        void push (int d) {
            mainStack.push(d);
            if (auxStack.empty() || d < auxStack.peek()) {
                auxStack.push(d);
            }
        }

        int pop () {
            int returnValue = mainStack.pop();
            if (returnValue == auxStack.peek()) {
                auxStack.pop();
            }
            return returnValue;
        }

        int min() {
            return auxStack.peek();
        }

    }

    public static void main(String[] args) {
        Question2Stack stack = new Question2Stack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.min());
        stack.pop();
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

        // Seems right!
        // TODO Confirm with Ulysses!


    }

}
