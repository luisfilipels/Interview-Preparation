package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static List<List<Integer>> subsets(int[]nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < (2 << nums.length-1); i++) {
            List<Integer> newList = new ArrayList<>();
            int shiftCount = 0;
            for (int j = 1; shiftCount < nums.length; j <<= 1) {
                if ((i & j) >> shiftCount == 1) {
                    newList.add(nums[shiftCount]);
                }
                shiftCount++;
            }
            returnList.add(newList);
        }
        return returnList;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
