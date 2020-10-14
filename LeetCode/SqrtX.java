public class SqrtX {

    private static int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        double low = 0, high = x;
        double current, mid;

        do {
            mid = (high + low)/2;
            current = mid * mid;
            if (current > x) {
                high = mid;
            } else if (current < x) {
                low = mid;
            } else {
                return (int) mid;
            }
        } while (Math.abs(x - current) >= 0.001);
        return (int) mid;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

}
