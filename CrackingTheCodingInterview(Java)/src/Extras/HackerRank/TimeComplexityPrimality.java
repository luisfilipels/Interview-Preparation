package Extras.HackerRank;

public class TimeComplexityPrimality {

    static String primality (int n) {
        // No need to use the sieve of Erathostenes here. We're only checking one number. Let's just skip even numbers,
        // starting at 3.
        if ((n % 2 == 0 && n != 2) || n == 1) {
            return "Not prime";
        }

        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";

    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println(primality(n));
    }

}
