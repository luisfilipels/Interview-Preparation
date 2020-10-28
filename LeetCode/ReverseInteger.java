public class ReverseInteger {

    private static int reverse(int x) {

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int places = 0;
        int temp = x;
        while (temp > 0) {
            temp /= 10;
            places++;
        }

        int newInt = 0;
        temp = x;
        while (places > 0) {
            int res = temp % 10;
            temp /= 10;
            newInt += res * Math.pow(10, --places);
            if (newInt >= Integer.MAX_VALUE) return 0;
        }

        return newInt * (isNegative ? -1 : 1);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }

}
