package Extras.LeetCode;

import java.util.HashMap;

public class FractionToRecurringDecimal {

    static String fractionToDecimal(int numerator, int denominator) {

        Long num = (long) numerator;    // To evade overflowing
        Long den = (long) denominator;
        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> hash = new HashMap<>();  // Key: a value of numerator. Value: The current position.
        boolean isNegative = false;
        if (num == 0) {
            return "0";
        }
        if (num < 0) isNegative = !isNegative;
        if (den < 0) isNegative = !isNegative;
        if (num % den == 0) {                   // If there is no decimal part, just return num/den
            return Long.toString(num/den);
        }
        // NOTE: We do NOT have to "manually" divide the integer part of the division! We get this part just by dividing num/den
        if (isNegative) sb.append("-");
        num = Math.abs(num);
        den = Math.abs(den);
        sb.append(num/den);
        sb.append(".");
        num = num % den;
        while (num % den != 0) {
            if (hash.containsKey(num)) {
                sb.insert(hash.get(num), "(");
                sb.append(")");
                return sb.toString();
            }
            hash.put(num, sb.length());
            num *= 10;
            sb.append(num/den);
            num = num % den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(Integer.MIN_VALUE, -1));
    }

}
