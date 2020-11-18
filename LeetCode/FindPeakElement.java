public class FindPeakElement {

    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < n-1; i++) {
            if (nums[i] > nums[i+1] && nums[i] > nums[i-1]) {
                return i;
            }
        }
        return nums.length-1;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[] {1,1,1,3,5,6,4}));
    }

}
