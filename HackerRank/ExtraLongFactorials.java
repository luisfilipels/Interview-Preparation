package Extras.HackerRank;

import java.math.BigInteger;

public class ExtraLongFactorials {

    static void extraLongFactorials(int n) {
        BigInteger result = new BigInteger("1");
        while (n >= 1) {
            result = result.multiply(BigInteger.valueOf(n--));
        }
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        extraLongFactorials(25);
    }

}
