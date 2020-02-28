package Extras.LeetCode;

import java.util.*;

public class FindTheCelebrity {

    static private boolean knows(int a, int b) {
        int [] array = knowsHash.get(a);
        for (int i : array) {
            if (i == b) return true;
        }
        return false;
    }

    static private int findCelebrity (int n) {
        int left = 0;
        int right = n-1;

        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }
        int candidate = left;

        /*
        // Eliminating candidates using a stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int personOne = stack.pop();
            int personTwo = stack.pop();

            if (knows(personOne, personTwo)) {
                stack.push(personTwo);
            } else {
                stack.push(personOne);
            }
        }

        int candidate = stack.pop();
        */

        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                if (!knows(i,candidate) || knows(candidate, i)) {
                    return -1;
                }
            }
        }
        return candidate;

    }

    static HashMap<Integer, int[]> knowsHash = new HashMap<>();

    public static void main(String[] args) {

        knowsHash.put(0, new int[] {1, 2});
        knowsHash.put(1, new int[] {0, 2, 3, 5});
        knowsHash.put(2, new int[] {});
        knowsHash.put(3, new int[] {2});
        knowsHash.put(4, new int[] {0, 2});
        knowsHash.put(5, new int[] {2});

        System.out.println(findCelebrity(6));
    }

}
