public class C3TestStack {
    public static void main(String[] args) {
        //C3Stack.LinkedListStack stack = new C3Stack.LinkedListStack();
        C3Stack.ArrayStack stack = new C3Stack.ArrayStack();
        System.out.println(stack.toString());
        stack.append(1);
        stack.append(2);
        stack.append(3);
        stack.append(4);
        stack.append(5);
        stack.pop();
        stack.clear();
        stack.pop();
        stack.append(1);
        stack.append(4);
        System.out.println(stack.toString());

    }
}
