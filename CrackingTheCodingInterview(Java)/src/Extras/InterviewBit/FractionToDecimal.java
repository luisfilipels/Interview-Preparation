package Extras.InterviewBit;

// Thanks to happygirlzt on YouTube for the code and explanation!
// github.com/happygirlzt

import java.util.HashMap;
import java.util.Map;

public class FractionToDecimal {

    public static String fractionToDecimal (int A, int B) {
        if (A == 0) {                                                           // Simple border case checks
            return "0";
        }
        StringBuilder string = new StringBuilder();
        if ((A < 0 && B > 0) || (A > 0 && B < 0)) {
            string.append("-");
        }

        long divisor = Math.abs((long) A);
        long dividend = Math.abs((long) B);
        long remainder = divisor % dividend;
        string.append(divisor/dividend);

        if (remainder == 0) {
            return string.toString();
        }

        string.append(".");
        Map<Long, Integer> map = new HashMap<>();                                // This will map a remainder to the string position in which the repetition starts
        while (remainder != 0) {                                                 // Will only be zero if there is no repetition
            if (map.containsKey(remainder)) {                                    // If the last calculated remainder has its first position already in the map...
                string.insert(map.get(remainder), "(");                      // Insert in the position represented by the value of the key <remainder> a "("
                string.append(")");
                break;
            }
            map.put(remainder, string.length());                                 // Since this remainder hasn't happened before, put it in the map
            remainder *= 10;                                                     // I don't understand from this point onwards :P
            string.append(remainder / dividend);
            remainder %= dividend;
        }
        return string.toString();

        // TODO : Understand this algorithm!
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2, 11));
    }
}
