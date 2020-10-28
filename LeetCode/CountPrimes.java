public class CountPrimes {

    // Simple Sieve of Eratosthenes
    private static int countPrimesSlow (int n) {
        if (n == 0 || n == 1 || n == 2) return 0;

        boolean [] isComposite = new boolean [n + 1];

        isComposite[0] = true;
        isComposite[1] = true;

        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (!isComposite[i]) count++;
            for (int j = i; j <= n; j += i) {
                isComposite[j] = true;
            }
        }

        return count;
    }

    // Sieve of Eratosthenes with optimizations
    private static int countPrimes (int n) {
        if (n == 0 || n == 1 || n == 2) return 0;

        boolean [] isComposite = new boolean [n + 1];

        isComposite[0] = true;
        isComposite[1] = true;

        int count = 1;
        int i;
        // Optimization 1: Only consider values of i that are odd.
        // Optimization 2: Limiting ourselves to i * i <= n. Why? From LeetCode:
        // We can mark off multiples of 5 starting at 5 × 5 = 25, because 5 × 2 = 10 was already marked off by multiple
        // of 2, similarly 5 × 3 = 15 was already marked off by multiple of 3. Therefore, if the current number is p,
        // we can always mark off multiples of p starting at p2, then in increments of p.
        for (i = 3; i * i <= n; i += 2) {
            if (!isComposite[i]) {
                count++;
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        while (i < n) {
            if (!isComposite[i]) {
                count++;
            }
            i += 2;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

}
