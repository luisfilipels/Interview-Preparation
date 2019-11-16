package Extras.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    private static int majorityElement (int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], 0);
            } else {
                hash.replace(nums[i], hash.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() >= nums.length/2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] input = new int[] {2,2,1,1,1,2,2};
        System.out.println(majorityElement(input));
    }

}
