public class C3TestStack {
    public static void main(String[] args) {
        C3StackArray.Stack stack = new C3StackArray.Stack();
        System.out.println(stack.toString());
        stack.append(1);
        stack.append(2);
        stack.append(3);
        stack.append(4);
        stack.append(5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.append(1);
        stack.append(2);
        stack.append(4);
        stack.append(8);
        while (!stack.empty()) {
            System.out.println(Integer.toString(stack.pop()) + " ");
        }

        System.out.println(stack.toString());
    }
}
