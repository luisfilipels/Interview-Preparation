import java.util.ArrayList;
import java.util.Stack;

public class C3Q3 {

    public static class SetOfStacks {

        ArrayList<Stack<Integer>> stacks = new ArrayList<>();

        int limit;

        SetOfStacks(int limit) {
            this.limit = limit;
        }

        void push(int x) {
            if (stacks.size() == 0) {
                stacks.add(new Stack<>());
            }
            Stack<Integer> currentStack = stacks.get(stacks.size()-1);
            if (currentStack.size() < limit) {
                currentStack.add(x);
            } else {
                stacks.add(new Stack<>());
                stacks.get(stacks.size()-1).push(x);
            }
        }

        int pop() {
            Stack<Integer> currentStack = stacks.get(stacks.size()-1);
            if (currentStack.isEmpty()) {
                stacks.remove(stacks.size()-1);
                return stacks.get(stacks.size()-1).pop();
            } else {
                return currentStack.pop();
            }
        }

        int peek() {
            Stack<Integer> currentStack = stacks.get(stacks.size()-1);
            return currentStack.peek();
        }
    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks(3);

        set.push(1);
        set.push(2);
        set.push(3);

        set.push(4);
        System.out.println(set.peek());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        System.out.println(set.pop());
        try {
            System.out.println(set.pop());
        } catch (Exception ignored) {}
        set.push(1);
        System.out.println(set.pop());
    }

}
