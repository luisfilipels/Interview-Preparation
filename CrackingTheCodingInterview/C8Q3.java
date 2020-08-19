public class C8Q3 {

    // With distinct integers
    static boolean findMagicIndex (int [] array) {
        int left = 0, right = array.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == array[mid]) return true;
            if (mid > array[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return false;
    }

    // With non-distinct integers
    static boolean findMagicIndexFollowUp (int [] array) {

    }

    public static void main(String[] args) {
        //int [] array = {4, 5, 6, 7, 8, 9, 10};
        int [] array = new int[] {-5, -4, -3, -1, 1, 2, 7, 8, 9, 10, 11};
        //int [] array = new int[] {-3, -2, 2};
        //int [] array = new int[] {0, 3, 4};
        System.out.println(findMagicIndex(array));
    }

}
