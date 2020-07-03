package Extras.LeetCode;

public class SingleNumber {

    static public int singleNumber (int [] nums) {
        int result = 0;
        for (int x : nums) {
            result = x ^ result;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums = {5, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
