public class PalindromeInteger {

    static int getIntegerLength(int input) {
        int result = 0;
        while (input > 0) {
            result++;
            input /= 10;
        }
        return result;
    }

    static int getIntAtIndex (int input, int inputLength, int index) {
        int currentIndex = inputLength - 1;

        int result = 0;
        while (currentIndex >= index) {
            result = input % 10;
            input /= 10;
            currentIndex--;
        }

        return result;
    }

    static public int isPalindrome(int A) {

        if (A == 0) return 1;

        if (A < 0) return 0;

        int length = getIntegerLength(A);

        int l = 0, r = length-1;

        while (l < r) {
            int atLeft = getIntAtIndex(A, length, l);
            int atRight = getIntAtIndex(A, length, r);

            if (atLeft != atRight) return 0;
            l++;
            r--;
        }

        return 1;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
    }

}
