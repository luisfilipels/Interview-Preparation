public class PowXN {

    public double helper(double x, long n) {

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == 2) {
            return x * x;
        } else {
            double pow = helper(x, n/2);
            if (n % 2 == 0) {
                return pow * pow;
            } else {
                return pow * pow * x;
            }
        }
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        if (n < 0) {
            n = -n;
            x = 1/x;
        }

        return helper(x, n);
    }

}
