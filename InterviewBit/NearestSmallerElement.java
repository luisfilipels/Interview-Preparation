package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {

    private static ArrayList<Integer> prevSmaller (ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int n : A) {
            while (!stack.empty() && stack.peek() >= n) {
                stack.pop();
            }
            if (stack.empty()) {
                arrayList.add(-1);
            } else {
                arrayList.add(stack.peek());
            }
            stack.add(n);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int [] array = {4, 5, 2, 10, 8};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        System.out.println(prevSmaller(arrayList).toString());
    }
}
