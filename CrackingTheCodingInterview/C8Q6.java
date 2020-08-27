import java.util.Stack;

public class C8Q6 {

    static Stack<Integer> stackA = new Stack<>();
    static Stack<Integer> stackB = new Stack<>();
    static Stack<Integer> stackC = new Stack<>();

    // Good explanation: https://www.reddit.com/r/learnpython/comments/38tsea/help_understanding_the_tower_of_hanoi_problem/
    static void towerOfHanoi (int remaining, Stack<Integer> origin, Stack<Integer> destination, Stack<Integer> buffer) {
        if (remaining == 0) {
            return;                                                                 // Base case. Do nothing
        }
        towerOfHanoi(remaining - 1, origin, buffer, destination);         // Move all n-1 elements from origin to buffer. Notice we will stop when we reach the base case.
        destination.push(origin.pop());                                             // Move what remained on the origin to the destination
        towerOfHanoi(remaining - 1, buffer, destination, origin);         // Move what we had previously moved from origin to buffer, now in buffer, to the destination, using origin as buffer, which is not being used.
    }

    public static void main(String[] args) {
        for (int i = 20; i > 0; i--) {
            stackA.push(i);
        }
        System.out.println(stackA.toString());
        System.out.println(stackB.toString());
        System.out.println(stackC.toString());

        System.out.println("===========");
        towerOfHanoi(stackA.size(), stackA, stackC, stackB);

        System.out.println(stackA.toString());
        System.out.println(stackB.toString());
        System.out.println(stackC.toString());

    }

}
