package Extras.InterviewBit;

import java.util.Stack;

public class MinStack {

    static class Solution {
        Stack<Integer> mainStack;
        Stack<Integer> auxStack;

        Solution () {
            mainStack = new Stack<>();
            auxStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
            if (auxStack.empty() || x < auxStack.peek()) {
                auxStack.push(x);
            }
        }

        public void pop() {
            try {
                int returnValue = mainStack.pop();
                if(returnValue == auxStack.peek()) {
                    auxStack.pop();
                }
            } catch (Exception ignored) {

            }

        }

        public int top() {
            try {
                return mainStack.peek();
            } catch (Exception e) {
                return -1;
            }
        }

        public int getMin() {
            try {
                return auxStack.peek();
            } catch (Exception e) {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();

    }

}
