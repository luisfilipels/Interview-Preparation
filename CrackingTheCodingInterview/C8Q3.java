public class C8Q3 {

    // With distinct integers
    static int findMagicIndex (int [] array) {
        int left = 0, right = array.length-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == array[mid]) return mid;
            if (mid > array[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    // With non-distinct integers
    static int findMagicIndexFollowUp (int [] array) {
        return findMagicIndexFollowUp(array, 0, array.length-1);
    }

    static int findMagicIndexFollowUp (int [] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (mid == array[mid]) return mid;

        if (left > right) return -1;

        int leftSearch= findMagicIndexFollowUp(array, left, Math.min(array[mid], mid-1));
        if (leftSearch >= 0) return leftSearch;

        return findMagicIndexFollowUp(array, Math.max(array[mid], mid+1), right);
    }

    public static void main(String[] args) {
        //int [] array = {4, 5, 6, 7, 8, 9, 10};
        int [] array = new int[] {-5, -4, -3, -1, 1, 2, 6, 8, 9, 10, 11};
        //int [] array = new int[] {-3, -2, 2};
        //int [] array = new int[] {0, 3, 4};
        System.out.println(findMagicIndex(array));
    }

}
