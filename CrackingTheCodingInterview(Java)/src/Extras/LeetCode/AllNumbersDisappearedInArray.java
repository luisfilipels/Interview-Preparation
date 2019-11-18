package Extras.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllNumbersDisappearedInArray {

    static List<Integer> findDisappearedNumbers (int [] nums) {
        List<Integer> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {                          // Marcamos posições como negativas apenas uma vez. Se o mesmo número aparecer novamente, ele não será negativado.
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                returnList.add(i + 1);
            }
        }
        return returnList;
    }

    /*
    // Solução O(n) tempo, mas O(n) espaço
    static List<Integer> findDisappearedNumbers (int[]nums) {
        List<Integer> returnList = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<>();
        for (int i : nums) {
            hash.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hash.contains(i)) {
                returnList.add(i);
            }
        }
        return returnList;
    }*/

    public static void main(String[] args) {
        //int [] input = new int[] {4,3,2,7,8,2,3,1};
        int [] input = new int[] {1,1};
        System.out.println(findDisappearedNumbers(input));
    }

}
