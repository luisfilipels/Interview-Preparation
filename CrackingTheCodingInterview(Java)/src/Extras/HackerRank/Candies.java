package Extras.HackerRank;

public class Candies {

    // My-"ish" response. Got really close.
    static long candies(int n, int[] arr) {
        long [] returnArray = new long[arr.length];
        returnArray[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                returnArray[i] = returnArray[i-1] + 1;
            } else {
                returnArray[i] = 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1] && returnArray[i] < returnArray[i+1] + 1) {
                returnArray[i] = returnArray[i+1] + 1;
            }
        }
        long count = 0;
        for (long i : returnArray) {
            count += i;
        }
        return count;


    }

    public static void main(String[] args) {

    }

}
