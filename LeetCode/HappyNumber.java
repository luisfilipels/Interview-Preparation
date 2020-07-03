package Extras.LeetCode;

import java.util.HashSet;

public class HappyNumber {

    private static boolean isHappy (int n) {
        HashSet<Integer> hasHappenedBefore = new HashSet<>();
        hasHappenedBefore.add(n);
        while (n != 1) {
            int currentSum = 0;
            while (n > 0) {
                currentSum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (hasHappenedBefore.contains(currentSum)) return false;
            hasHappenedBefore.add(currentSum);
            n = currentSum;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
