package Extras.LeetCode;

import java.util.*;

public class ThreeSum {


    // Greatly improved solution. Takes around 28ms.
    private static List<List<Integer>> threeSum (int [] nums) {
        if (nums.length <= 2) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> returnList = new LinkedList<>();
        int currentFixed = nums[0];
        for (int fixedIdx = -1; fixedIdx < nums.length - 2; fixedIdx++) {
            if (fixedIdx == -1) {
                fixedIdx++;
            } else {
                while (fixedIdx < nums.length && nums[fixedIdx] == currentFixed) fixedIdx++;
                if (fixedIdx == nums.length) break;
            }
            currentFixed = nums[fixedIdx];
            int start = fixedIdx+1;
            int end = nums.length-1;
            while (start < end) {
                int result = nums[fixedIdx] + nums[start] + nums[end];
                if (result >= 0) {
                    if (result == 0) {
                        returnList.add(new LinkedList<>());
                        int m = returnList.size();
                        returnList.get(m-1).add(nums[fixedIdx]);
                        returnList.get(m-1).add(nums[start]);
                        returnList.get(m-1).add(nums[end]);
                    }
                    int currentEnd = nums[end];
                    while (start < end && nums[end] == currentEnd) end--;
                } else {
                    int currentStart = nums[start];
                    while (start < end && nums[start] == currentStart) start++;
                }
            }
        }
        return returnList;
    }

    // Slightly improved solution. Still takes a lot of time and space.
    /*private static List<List<Integer>> threeSum (int [] nums) {
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
    }*/

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
        //int [] nums = new int[] {-6, -1, 1, 0, -8, 2, 6, 4};
        int [] nums = new int[] {0,0,0,0};
        System.out.println(threeSum(nums));
    }

}
