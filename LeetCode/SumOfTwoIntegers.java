public class SumOfTwoIntegers {

    static int getBit(int n, int i) {
        return (n >> i) & 1;
    }

    static int setBit(int n, int i) {
        return (1 << i) | n;
    }

    static int resetBit(int n, int i) {
        return ~(i << i) & n;
    }

    static int increment(int n) {
        return -(~n);
    }

    // My first solution. Correct, but the code is not simple. We manually do the summation, bit by bit, considering each
    // bit from a and b. We don't need to consider a case in which a is positive and b is negative or vice-verse, as the
    // negative number will be in two's complement notation.
    private static int getSumSlow(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        int sum = 0;
        int carry = 0;
        for (int currentBit = 0; currentBit < 32; currentBit = increment(currentBit)) {
            int aBit = getBit(a, currentBit);
            int bBit = getBit(b, currentBit);
            int resultBit;
            if ((aBit & bBit) == 1) {   // a and b are 1
                if (carry == 1) {
                    resultBit = 1;
                } else {
                    carry = 1;
                    resultBit = 0;
                }
            } else {                        // a and b are not 1
                int xor = aBit ^ bBit;
                xor = xor ^ carry;
                if (xor == 1) {     // only one element is 1
                    carry = 0;
                    resultBit = 1;
                } else {
                    int or = aBit | bBit;
                    or = or | carry;
                    resultBit = 0;
                    if (or != 0) {  // carry and a, or carry and b are 1
                        carry = 1;
                    }
                }
            }
            if (resultBit == 1) {
                sum = setBit(sum, currentBit);
            } else {
                sum = resetBit(sum, currentBit);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSumSlow(123, -39));
    }

}
