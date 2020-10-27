import java.math.BigDecimal;

public class PowerOfThree {

    // This solution is, unfortunately, imprecise, but will yield the correct result in LeetCode.
    private static boolean isPowerOfThree (int n) {
        if (n == 0) return false;
        double result = Math.log(n) / Math.log(3);
        System.out.println(result);

        double ceil = Math.ceil(result);
        double floor = Math.floor(result);

        if (Math.abs(result - ceil) < 0.0000000001 || Math.abs(result - floor) < 0.0000000001) return true;

        return false;
    }

    // Fastest solution, which is precise for integers, that is what's requested
    private static boolean isPowerOfThree2 (int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(1162261467));
    }

}
