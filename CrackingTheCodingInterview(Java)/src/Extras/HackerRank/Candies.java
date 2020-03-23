package Extras.HackerRank;

public class Candies {

    // My-"ish" response. Got really close.
    static long candies(int n, int[] arr) {
        int [] returnArray = new int[arr.length];
        returnArray[0] = 1;
        for (int i = 1; i < arr.length; i++) { // First, go left to right setting up the slopes that grow in this direction.
            if (arr[i] > arr[i-1]) {
                returnArray[i] = returnArray[i-1] + 1;
            } else {
                returnArray[i] = 1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) { // Then, do the same on the other side, for the slopes that form right to left
            if (arr[i] > arr[i+1] && returnArray[i] < returnArray[i+1] + 1) {
                returnArray[i] = returnArray[i+1] + 1;
            }
        }
        int count = 0;
        for (int i : returnArray) {
            count += i;
        }
        return count;

    }

    public static void main(String[] args) {

    }

}
