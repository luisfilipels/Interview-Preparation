package Extras.LeetCode;

import java.util.*;

public class ThreeSum {

    // Slightly improved solution. Still takes a lot of time and space.
    private static List<List<Integer>> threeSum (int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        HashSet<ArrayList<Integer>> inList = new HashSet<>();
        for (int start = 0; start < nums.length; start++) {
            if (start == 0 || nums[start] != nums[start-1]) {
                if (nums[start] > 0) break;
                HashMap<Integer, Integer> hash = new HashMap<>();
                int target = nums[start] * -1;
                for (int i = start + 1; i < nums.length; i++) {
                    if (hash.containsKey(nums[i])) {
                        ArrayList<Integer> newList = new ArrayList<>();
                        newList.add(nums[start]);
                        newList.add(nums[hash.get(nums[i])]);
                        newList.add(nums[i]);
                        if (!inList.contains(newList)) {
                            returnList.add(newList);
                            inList.add(newList);
                        }
                    }
                    hash.put(target - nums[i], i);
                }
            }
        }
        return returnList;
    }

    /*
    // First solution. Accepted (sometimes), but takes quite some time.
    private static List<List<Integer>> threeSum (int [] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        HashSet<ArrayList<Integer>> inList = new HashSet<>();
        for (int start = 0; start < nums.length; start++) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            int target = nums[start] * -1;
            for (int i = start + 1; i < nums.length; i++) {
                if (hash.containsKey(nums[i])) {
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(nums[start]);
                    newList.add(nums[hash.get(nums[i])]);
                    newList.add(nums[i]);
                    newList.sort((x1, x2) -> x1 - x2);
                    if (!inList.contains(newList)) {
                        returnList.add(newList);
                        inList.add(newList);
                    }
                }
                hash.put(target - nums[i], i);
            }
        }
        return returnList;
    }
    */

    public static void main(String[] args) {
        //int [] nums = new int[] {-1,0,1,2,-1,-4};
        int [] nums = new int[] {0,0,0,0};
        System.out.println(threeSum(nums));
    }

}
