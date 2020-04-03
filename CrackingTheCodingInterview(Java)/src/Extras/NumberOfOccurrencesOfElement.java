package Extras;

public class NumberOfOccurrencesOfElement {

    static int countOccurrences (int [] arr, int target) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int mid = end + (start-end)/2;
            if (arr[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int first = start+1;
        if (arr[first] != target) return 0;
        start = 0;
        end = arr.length;

        while (start < end) {
            int mid = start + (end-start)/2;
            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int last = start - 1;
        return last - first + 1;

    }

    public static void main(String[] args) {
        int [] arr = new int[] {3, 5, 5, 5, 5, 7, 8, 8};
        System.out.println(countOccurrences(arr, 5));
    }


}
