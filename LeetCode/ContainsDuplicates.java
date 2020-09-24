import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {

    static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> inSet = new HashSet<>();
        for (int i : nums) {
            if (inSet.contains(i)) return true;
            inSet.add(i);
        }
        return false;
    }

    static boolean containsDuplicate2 (int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
