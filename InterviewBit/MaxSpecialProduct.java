package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

public class MaxSpecialProduct {

    public static int MAXSPPROD (ArrayList<Integer> A) {

        Stack<Integer> integerStack = new Stack<>();
        int left = 0;
        for (int i = 0; i < A.size(); i++) {
            if (integerStack.size() > 0) {
                try {
                    while (integerStack.peek() <= A.get(i)) {
                        integerStack.pop();
                        left = i;
                    }
                } catch (Exception ignored) {
                    break;
                }
            }

            integerStack.push(A.get(i));
        }
        while (!integerStack.empty()) {
            integerStack.pop();
        }
        int right = 0;
        for (int i = 0; i < A.size(); i++) {
            if (integerStack.size() > 0) {
                try {
                    while (integerStack.peek() >= A.get(i)) {
                        integerStack.pop();
                        left = i;
                    }
                } catch (Exception ignored) {
                    break;
                }
            }
            integerStack.push(A.get(i));
        }
        return (left * right) % 1000000007;
        /*int maxProd = 0;
        for (int i = 0; i < A.size(); i++) {
            int left = 0;
            int right = 0;
            boolean multiple = false;
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    continue;
                }
                if (A.get(j) > A.get(i) && !multiple) {
                    left = j;
                    multiple = true;
                } else if (A.get(j) > A.get(i) && multiple) {
                    left = Math.max(left, j);
                }
            }
            multiple = false;
            for (int j = i; j < A.size(); j++) {
                if (j == i) {
                    continue;
                }
                if (A.get(j) > A.get(i) && !multiple) {
                    right = j;
                    multiple = true;
                } else if (A.get(j) > A.get(i) && multiple){
                    right = Math.min(right, j);
                }
            }
            maxProd = Math.max(maxProd, left * right);
        }
        return maxProd % 1000000007;*/
    }

    public static void main(String[] args) {
        int [] input = {3, 1, 2, 4, 5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : input) {
            A.add(i);
        }
        System.out.println(MAXSPPROD(A));
    }
}
