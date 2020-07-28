import java.util.Stack;

public class C3Q5 {

    /*
    Although the book presents an optimal and shorter answer, I believe mine's a bit more intuitive.
    We can solve this question with 3 steps:
    1) Find the maximum element in the input stack. Do so by moving all elements from input to returnStack, and checking which one is the maximum.
    2) Move all the elements from returnStack to inputStack. Check at each pop if the element we have is the maximum. If so, save it, and don't move it into inputStack.
    Continue moving the remaining elements. Move at most numsRemaining numbers, so that we don't move elements that have already been sorted.
    3) Push the maximum element we've saved into the returnStack, and decrement numsRemaining. Repeat from step 1 until numsRemaining == 0.
     */

    static Stack<Integer> sortStack (Stack<Integer> inputStack) {
        Stack<Integer> returnStack = new Stack<>();
        int numsRemaining = inputStack.size();
        while (numsRemaining != 0) {
            // Step 1: Find max (inputStack -> returnStack)
            int max = Integer.MIN_VALUE;
            while (!inputStack.isEmpty()) {
                int current = inputStack.pop();
                max = Math.max(max, current);
                returnStack.push(current);
            }
            // Step 2: Save max element into saveMax (returnStack -> inputStack) (max times: numsRemaining)
            Integer saveMax = null;
            for (int i = 0; i < numsRemaining; i++) {
                Integer current = returnStack.pop();
                if (saveMax == null) {
                    if (current == max) {
                        saveMax = current;
                        current = null;
                    }
                }
                if (current != null) inputStack.push(current);
            }
            // Step 3: Push saveMax to returnStack and decrement numsRemaining
            returnStack.push(saveMax);
            numsRemaining--;
        }
        return returnStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        /*stack.add(0);
        stack.add(2);
        stack.add(9);
        stack.add(1);
        stack.add(9);
        stack.add(4);
        stack.add(3);
        stack.add(10);*/

        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(2);
        stack.push(1);

        stack = sortStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
