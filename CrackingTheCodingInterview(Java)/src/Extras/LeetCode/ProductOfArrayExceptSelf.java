package Extras.LeetCode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // My solution with O(n) time and space complexity
    static private int [] productExceptSelf(int[] nums) {
        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        int [] returnArray = new int[nums.length];

        int acumulator = 1;
        for (int i = 0; i < nums.length; i++) {
            acumulator *= nums[i];
            left[i] = acumulator;
        }
        acumulator = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            acumulator *= nums[i];
            right[i]= acumulator;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                returnArray[i] = right[i+1];
            } else if (i == nums.length - 1) {
                returnArray[i] = left[i-1];
            } else {
                returnArray[i] = right[i+1] * left[i-1];
            }
        }
        return returnArray;
    }

    // Recommended solution with O(n) time and O(1) space:
    public int[] productExceptSelfRecommended(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int [] input = new int[] {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

}
