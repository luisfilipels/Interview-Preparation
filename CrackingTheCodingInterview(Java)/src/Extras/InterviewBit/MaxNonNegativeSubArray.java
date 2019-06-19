package Extras.InterviewBit;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {
    public static ArrayList<Integer> maxNonNegative(ArrayList<Integer> A) {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<Integer>();
        ArrayList<Integer> newArray = new ArrayList<Integer>();
        for (Integer i : A) {
            if (i >= 0) {
                newSum += i;
                newArray.add(i);
            } else {
                newSum = 0;
                newArray = new ArrayList<Integer>();
            }
            if ((maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size()))) {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;
        /*int maxSum = 0;
        int sumSoFar = 0;
        int maxIndexCandidate = 0;
        int startCandidate = 0;
        int maxIndex = 0;
        int startIndex = 0;
        boolean thereIsPositive = false;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                thereIsPositive = true;
            }
        }
        if (!thereIsPositive) {
            int[] returnArray = {};
            return returnArray;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                sumSoFar += A[i];
                maxIndexCandidate = i;
                if (sumSoFar > maxSum) {
                    startIndex = startCandidate;
                    maxIndex = maxIndexCandidate;
                    maxSum = sumSoFar;
                }
            } else {
                while (A[i] < 0) {
                    i++;
                    if (i >= A.length) {
                        break;
                    }
                }
                i--;
                startCandidate = i+1;
                sumSoFar = 0;
            }
        }
        int [] returnArray = new int[maxIndex - startIndex + 1];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = A[i+startIndex];
        }
        return returnArray;*/
    }

    public static void main(String[] args) {
        //int [] input = {0, 0, -1, 0};
        //int [] input = {1, 2, 5000, -7, 2000, 10, -10, 300, 1};
        int [] input = {1, 2, 5, -7, 2, 3};
        //int [] input = {-1, -1, -1, -1};
        //int [] input = {-846930886, -1714636915, 424238335, -1649760492};
        ArrayList<Integer> entry = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            entry.add(input[i]);
        }
        System.out.println(maxNonNegative(entry));
        System.out.println(":D");
    }
}
