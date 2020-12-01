public class IncreasingTripletSubsequence {

    private static boolean increasingTripletSubsequence (int [] nums) {
        int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x <= num1) num1 = x;
            else if (x <= num2) num2 = x;    // Once num1 is set, we can set num2
            else return true;   // If num1 and num2 are set and the current number is greater than both, return true
        }

        return false;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {
                4,3,2,1,5,2,0,4
        };
        System.out.println(increasingTripletSubsequence(nums));
    }

}
