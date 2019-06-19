package Extras.InterviewBit;

// Não entendi a solução.

public class MaxSumContiguous {

    public static int maxSum(final int [] A) {
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }
        if (max < 0) {
            return max;
        }
        max = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum + A[i] > 0) {
                sum += A[i];
            } else {
                sum = 0;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] entry = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(entry));
    }
}
