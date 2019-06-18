package Extras.InterviewBit;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {

    public static int findPath (int[] A, int[] B) {
        int response = 0;
        for (int i = 1; i < A.length; i++) {
            int [] ptA = {A[i-1], B[i-1]};
            int [] ptB = {A[i], B[i]};
            int remainingX = Math.abs(ptB[0] - ptA[0]);
            int remainingY = Math.abs(ptB[1] - ptA[1]);
            while (remainingX != 0 || remainingY != 0) {
                if (remainingX == 0) {
                    remainingY--;
                    response++;
                } else if (remainingY == 0) {
                    remainingX--;
                    response++;
                } else if (remainingX != 0 && remainingY != 0) {
                    remainingX--;
                    remainingY--;
                    response++;
                }
            }
        }
        return response;
    }

    public static void main(String[] args) {
        int [] A = {1, 4, 3};
        int [] B = {1, 3, 4};
        System.out.println(findPath(A, B));
    }
}
