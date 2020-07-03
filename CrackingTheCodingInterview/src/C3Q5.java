import java.util.Stack;

public class C3Q5 {

    public static Stack<Integer> sortStack (Stack<Integer> input) {
        Stack <Integer> newStack = new Stack<>();
        while (!input.empty()) {
            int t = input.pop();
            while (!newStack.empty() && t < newStack.peek() ) {
                input.add(newStack.pop());
            }
            newStack.add(t);
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(2);
        stack.add(1);
        stack.add(9);
        stack.add(4);
        stack.add(3);
        stack.add(10);

        stack = sortStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }


    }
}
