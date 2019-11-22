package Extras.LeetCode;

public class KthLargestElement {

    static int findKthLargest (int [] nums, int k) {
        // Pode ser feito com ordenação ou fila de prioridade, porém ambos demoram mais tempo que o QuickSelect.
        // Mais detalhes em https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time
        return select(nums, 0, nums.length-1, k);
        //return quickSelect(nums, 0, nums.length - 1, k);
    }

    static void swap (int [] nums, int i, int j) {
        int swap = nums[i];
        nums[i] = nums[j];
        nums[j] = swap;
    }

    private static int select(int[] nums, int start, int end, int k) {
        while (true) {
            int pivot = start;
            for (int j = start; j < end; j++) {
                if (nums[j] <= nums[end]) {
                    swap(nums, pivot++, j);
                }
            }
            swap(nums, pivot, end);
            int count = end - pivot + 1;
            if (count == k) return nums[pivot];
            if (count > k) {
                start = pivot+1;
            } else {
                end = pivot-1;
                k -= count;
            }
        }
    }

    static int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        for (int j = low; j < high; j++) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, high);

        // count the nums that are > pivot from high
        int count = high - pivot + 1;
        // pivot is the one!
        if (count == k) return nums[pivot];
        // pivot is too small, so it must be on the right
        if (count > k) return quickSelect(nums, pivot + 1, high, k);
        // pivot is too big, so it must be on the left
        return quickSelect(nums, low, pivot - 1, k - count);
    }

    public static void main(String[] args) {
        int [] nums = new int[] {3,2,3,1,2,4,5,5,6};
        //int [] nums = new int[] {2, 1};
        //int [] nums = new int[] {3,2,1,5,6,4};
        //System.out.println(select(nums, 0, nums.length-1, 4));
        System.out.println(findKthLargest(nums, 4));
        //partition(nums, 0, nums.length-1, 4);
        //System.out.println(Arrays.toString(nums));
        //System.out.println(findKthLargest(nums, 2));
    }
}
