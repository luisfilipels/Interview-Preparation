package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumUnsortedSubarray {

    public static ArrayList<Integer> maximumUnsortedSubArray (ArrayList<Integer> A) {
        ArrayList<Integer> original = new ArrayList<>(A);
        Collections.sort(A);
        int start = 0;
        int end = 0;
        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).equals(original.get(i))) {
                start = i;
                end = i;
                break;
            }
        }
        for (int i = A.size()-1; i > 0; i--) {
            if (!A.get(i).equals(original.get(i))) {
                end = i;
                break;
            }
        }
        ArrayList<Integer> returnArray = new ArrayList<>();
        if (start == 0 && end == 0) {
            returnArray.add(-1);
            return returnArray;
        }
        returnArray.add(start);
        returnArray.add(end);
        return returnArray;
    }

    public static void main(String[] args) {
        int [] input = {1, 5, 4, 3, 5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i1 : input) {
            A.add(i1);
        }
        A = maximumUnsortedSubArray(A);
        for (Integer integer : A) {
            System.out.print(integer);
            System.out.print(" ");
        }

    }
}
