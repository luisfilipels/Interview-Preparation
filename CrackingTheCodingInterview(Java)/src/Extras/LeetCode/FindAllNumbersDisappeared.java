package Extras.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {

    private static List<Integer> findDisappearedNumbers (int [] nums) {
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

    public static void main(String[] args) {

    }

}
