import java.util.Stack;

public class C3Q2 {
    /*
        This is quite a simple question to answer if you're allowed to use a regular stack that accepts two integers for
        each element of the stack. In this case, we can define a class Pair that holds the integer to be inserted into the
        stack, and another integer that holds the minimum number that's present in the stack. Example:

                                                                                        3 2
                                                                        2 2             2 2                        2 2
                                                        6 4             6 4             6 4                        6 4
                                        5 4             5 4             5 4             5 4                        5 4
           ->push(4)->  4 4 ->push(5)-> 4 4 ->push(6)-> 4 4 ->push(2)-> 4 4 ->push(3)-> 4 4 -> min()  -> pop()  -> 4 4
        _ _             _ _             _ _             _ _             _ _             _ _   returns   returns    _ _
        S M             S M             S M             S M             S M             S M      2         3       S M

        Above, S represents the numbers inserted onto the stack, and M indicates the minimum element inserted so far.
        When we push an element, not only do we insert the element itself, but we also check if said elements is less than
        the minimum element inserted so far, dealing with each case in a different manner.

        We can also save space by keeping track of two stacks instead, one for the numbers that are in the stack itself,
        and another for the minimums.
     */

    public static class Pair {
        int number, min;

        Pair(int n, int m) {
            number = n;
            min = m;
        }
    }

    public static class MinStack {
        Stack<Pair> stack = new Stack<>();

        void push (int x) {
            if (stack.isEmpty()) {
                stack.push(new Pair(x, x));
            } else {
                int peek = stack.peek().min;
                if (x < peek) {
                    stack.push(new Pair(x,x));
                } else {
                    stack.push(new Pair(x, peek));
                }
            }
        }

        void pop () {
            stack.pop();
        }

        int min () {
            return stack.peek().min;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
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

    }

}
