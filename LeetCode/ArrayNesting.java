public class ArrayNesting {

    static public int arrayNesting(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, recursion(nums, i));
        }
        return max;
    }

    static int recursion (int[] nums, int index) {
        if (index == -1 || nums[index] == -1) return 0;
        int bkp = nums[index];
        nums[index] = -1;
        int result = recursion(nums, bkp) + 1;
        nums[index] = bkp;
        return result;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {5,4,0,3,1,6,2};

        System.out.println(arrayNesting(arr));
    }

}
