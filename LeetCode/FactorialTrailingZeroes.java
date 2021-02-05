public class FactorialTrailingZeroes {

    private static int trailingZeroes (int n) {
        int count = 0;
        int divider = 5;
        while (divider <= n) {
            // multiples of 5 occur every 5 numbers, and multiples of 2, every 2 numbers. There are many more multiples
            // of 2 than there are of 5, so we count the amount of 5s.
            count += n / divider; // Count the number of 5's
            divider *= 5;   // Next, we count the amount of 25s (as it counts as 2 5s), then of 125s...
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }

}
