package Extras.InterviewBit;

import java.util.ArrayList;
import java.util.HashSet;

public class ColorfulNumber {

    public static int colorful(int A) {
        HashSet<Integer> hash = new HashSet<>();
        String string = Integer.toString(A);
        int size = 1;
        while (size <= string.length()) {
            for (int i = 0; i < string.length(); i++) {
                StringBuilder current = new StringBuilder();
                int acumulator = 1;
                int x = 0;
                if (i + size > string.length()) {
                    break;
                }
                for (int j = i; x < size && j < string.length(); x++) {
                    current.append(string.charAt(j));
                    j++;
                }
                for (int j = 0; j < current.length(); j++) {
                    acumulator *= Character.getNumericValue(current.charAt(j));
                }
                if (!hash.contains(acumulator)) {
                    hash.add(acumulator);
                } else {
                    return 0;
                }
            }
            size++;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(colorful(123));
    }

}
