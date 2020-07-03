package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> returnList = new ArrayList<>();
        ArrayList<Integer> currentList = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            if (!currentList.contains(nums[i])) {
                ArrayList<Integer> newList = new ArrayList<>(currentList);
                newList.add(nums[i]);
                if (newList.size() == nums.length) {
                    returnList.add(newList);
                } else {
                    helper(nums, returnList, newList);
                }
            }
        }
        return returnList;

    }

    static private void helper (int [] nums, List<List<Integer>> returnList, List<Integer> currentList) {
        for (int i = 0; i < nums.length; i++) {
            if (!currentList.contains(nums[i])) {
                ArrayList<Integer> newList = new ArrayList<>(currentList);
                newList.add(nums[i]);
                if (newList.size() == nums.length) {
                    returnList.add(newList);
                } else {
                    helper(nums, returnList, newList);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] nums = {};
        System.out.println(permute(nums));
    }

}
