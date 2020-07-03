package Extras.LeetCode;

public class MedianOfTwoSortedArrays {

    private static double findMedianSortedArrays (int [] nums1, int [] nums2) {

        // Tushar Roy has a great explanation for this one. No need to look at his code to get the solution right.

        if (nums2.length < nums1.length) {
            int [] swap = nums1;
            nums1 = nums2;
            nums2 = swap;
        }
        if (nums1.length == 0) {
            int n = nums2.length;
            return n % 2 == 0 ? ((double)nums2[n/2] + (double)nums2[(n/2)-1])/2 : nums2[n/2];
        }

        int maxLeftNum1;
        int minRightNum1;

        int minRightNum2;
        int maxLeftNum2;

        int startNum1 = 0;
        int endNum1 = nums1.length;

        int pNum2Ratio = (nums1.length + nums2.length + 1)/2;

        while (true){
            int partitionNum1 = (startNum1 + endNum1) / 2;
            int partitionNum2 = pNum2Ratio - partitionNum1;
            maxLeftNum1 = partitionNum1 - 1 == -1 ? Integer.MIN_VALUE : nums1[partitionNum1-1];
            maxLeftNum2 = partitionNum2 - 1 == -1 ? Integer.MIN_VALUE : nums2[partitionNum2-1];
            minRightNum1 = partitionNum1 == nums1.length ? Integer.MAX_VALUE : nums1[partitionNum1];
            minRightNum2 = partitionNum2 == nums2.length ? Integer.MAX_VALUE : nums2[partitionNum2];

            if (maxLeftNum1 <= minRightNum2 && maxLeftNum2 <= minRightNum1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (Math.max((double) maxLeftNum1,(double) maxLeftNum2) + Math.min((double) minRightNum1,(double)minRightNum2))/2;
                } else {
                    return Math.max(maxLeftNum1, maxLeftNum2);
                }
            } else if (maxLeftNum1 > minRightNum2){
                endNum1 = partitionNum1 - 1;
            } else {
                startNum1 = partitionNum1 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int [] nums1 = new int[] {1,3};
        int [] nums2 = new int[] {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

}
