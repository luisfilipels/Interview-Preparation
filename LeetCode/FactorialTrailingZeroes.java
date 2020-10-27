public class FactorialTrailingZeroes {

    private static int trailingZeroes (int n) {
        int count = 0;
        int divider = 5;
        while (divider <= n) {
            count += n / divider;
            divider *= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
    }

}
