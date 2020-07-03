package Extras.HackerRank;

public class FlippingBits {

    static long flippingBits(long n) {
        return ~n & 0x00000000ffffffffL;
    }

    public static void main(String[] args) {
        long n = 0;
        long result = flippingBits(n);
        System.out.println(Long.toBinaryString(n));
        System.out.println(Long.toBinaryString(result));
        System.out.println(result);

    }

}
