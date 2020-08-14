public class C6Q5 {

    static int gcd (int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static boolean canFormObj (int maxA, int maxB, int obj) {
        int gcd = gcd(maxA, maxB);

        if (obj % gcd != 0) return false;
        if (obj > maxA && obj > maxB) return false;

        if (maxB > maxA) {
            int temp = maxA;
            maxB = maxA;
            maxA = temp;
        }

        int currentA = 0, currentB = 0;

        while (currentA != obj && currentB != obj) {
            if (currentA == 0) {
                currentA = maxA;
            }

            int remainToFill = Math.min(currentA, maxB - currentB);
            currentA -= remainToFill;
            currentB += remainToFill;

            if (currentA == obj || currentB == obj) return true;

            if (currentB == maxB) currentB = 0;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canFormObj(5, 2, 3));
        System.out.println(canFormObj(2, 3, 4));
    }

}
