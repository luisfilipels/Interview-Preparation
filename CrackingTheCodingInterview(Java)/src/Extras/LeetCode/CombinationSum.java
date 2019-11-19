package Extras.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    static List<List<Integer>> combinationSum (int [] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> blankList = new ArrayList<>();
        helper(blankList, returnList, candidates, 0, target, 0);
        return returnList;
    }

    static void helper (List<Integer> currentList, List<List<Integer>> returnList, int [] candidates, int currentListSum, int target, int start) {
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] + currentListSum <= target) {
                int currentSum = candidates[i] + currentListSum;
                List<Integer> newList = new ArrayList<>(currentList);
                newList.add(candidates[i]);
                if (currentSum == target) {
                    returnList.add(newList);
                    return;
                } else {
                    helper(newList, returnList, candidates, currentSum, target, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] candidates = new int[] {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }

}
