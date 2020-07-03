package Extras.LeetCode;

public class BitwiseANDofRange {

    /*
    Let's look at the range from 0 to 15, in binary:
    0000 0
    0001 1
    0010 2
    0011 3
    0100 4
    0101 5
    0110 6
    0111 7
    1000 8
    1001 9
    1010 10
    1011 11
    1100 12
    1101 13
    1110 14
    1111 15

    Notice that if we AND any two adjacent numbers, the rightmost bit will always be zero. If we look at the bit immediately
    to its left, we can notice that it will be zero if n-m >= 2, and if that's not the case (n-m == 1), it can still be
    zero if their respective bits are different (or zero). For the next bit, if n-m >= 4, the bit will be zero. If n-m<4,
    then we can check the 2 bits in order to see if the bit is zero or not. Repeating this logic for all other bits, we
    reach the correct answer.

     */
    private static int rangeBitwiseAnd(int m, int n) {
        int returnValue = 0;
        int shift = 0;
        int trackM = m; // Used to preserve m
        int trackN = n; // Used to preserve n
        while (trackM > 0 && trackN > 0) {
            trackM = trackM >> 1;
            trackN = trackN >> 1;
            if (n - m < (1 << shift)) {
                int bitM = (m >> shift) & 1;
                int bitN = (n >> shift) & 1;
                if (bitM == 1 && bitN == 1) {
                    returnValue += 1 << shift;
                }
            }
            shift++;
        }
        return returnValue;
    }

    public static void main(String[] args) {

    }

}
