import java.util.ArrayList;
import java.util.Stack;

public class C3Q3 {

    public static class SetOfStacks {

        int capacity;
        ArrayList<Stack<Integer>> stacks;

        SetOfStacks (int capacity) {
            this.capacity = capacity;
            stacks = new ArrayList<>();
            stacks.add(new Stack<>());
        }

        void push (int d) {
            if (stacks.size() == 0) {
                stacks.add(new Stack<>());
            }
            if (stacks.get(stacks.size()-1).size() < capacity) {
                stacks.get(stacks.size()-1).push(d);
            } else {
                System.out.println("Stack full! Creating new stack!");
                stacks.add(new Stack<>());
                stacks.get(stacks.size()-1).push(d);
            }
        }

        int pop () {
            if (stacks.get(stacks.size() - 1).size() == 1) {
                int returnInt = stacks.get(stacks.size() - 1).pop();
                stacks.remove(stacks.size() - 1);
                return returnInt;
            } else {
                return stacks.get(stacks.size() - 1).pop();
            }
        }

        int popAt (int index) {
            if (stacks.get(index).size() == 1) {
                int returnInt = stacks.get(index).pop();
                stacks.remove(index);
                return returnInt;
            } else {
                return stacks.get(index).pop();
            }
        }

        // TODO Implement "rollover" for popAt

    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks(3);
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        set.push(5);
        set.push(6);
        set.push(7);
        set.pop();
        set.push(7);
        try {
            while (true) {
                System.out.println(set.pop());
            }
        } catch (Exception ignored) {}

        set.push(10);
        System.out.println(set.pop());
        set.push(1);
        set.push(2);
        set.push(3);
        set.push(4);
        set.push(5);
        set.push(6);
        set.push(7);
        System.out.println();
        System.out.println(set.popAt(0));
        System.out.println(set.popAt(1));
        System.out.println();
        try {
            while (true) {
                System.out.println(set.pop());
            }
        } catch (Exception ignored) {}
    }

}
