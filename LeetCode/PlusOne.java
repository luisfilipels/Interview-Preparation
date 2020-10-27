import java.util.Arrays;

public class PlusOne {

    private static int [] plusOne (int [] digits) {
        int n = digits.length;

        int carry = 1;
        for (int i = n-1; i >= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) {
                carry = 0;
            } else {
                digits[i] -= 10;
            }
        }
        if (carry == 1) {
            int [] newDigits = new int[n+1];
            newDigits[0] = 1;
            for (int i = 0; i < n; i++) {
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        int [] digits = new int [] {
                9, 9, 9
        };
        System.out.println(Arrays.toString(plusOne(digits)));
    }

}
