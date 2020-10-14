public class MissingNumber {

    static void invertOrSetZero(int [] nums, int current, int n) {
        if (nums[current] == 0) {
            nums[current] = (n+1) * -1;
        } else {
            nums[current] = nums[current] * -1;
        }
    }

    // O(n) time, O(1) space solution
    // We use the indices of each number in the array to indicate whether we've seen that particular number before. So,
    // if we have the array [2, 0, 1], we mark the element at index 2 as negative, then the element at index 0 as negative,
    // and finally, the item at index 1. We then have the following array: [-2, 0, -1]. Since 0 can't be negative, we mark
    // it instead as n+1, that is a number that can't be in the array, while making sure that this handling is correct in
    // all cases.
    private static int missingNumber (int[] nums) {
        int n = nums.length;

        boolean nIsPresent = false;
        boolean zeroIsPresent = false;
        for (int i = 0; i < n; i++) {
            int current;
            current = Math.abs(nums[i]);
            if (current == n+1) current = 0;
            if (current == 0) {
                zeroIsPresent = true;
                invertOrSetZero(nums, current, n);
            } else if (current == n) {
                nIsPresent = true;
            } else {
                invertOrSetZero(nums, current, n);
            }
        }

        if (!nIsPresent) return n;
        if (!zeroIsPresent) return 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[] {0, 2}));
        System.out.println(missingNumber(new int[] {3, 0, 1}));
        System.out.println(missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
        System.out.println(missingNumber(new int[] {2, 0}));
    }

}
