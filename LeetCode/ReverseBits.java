public class ReverseBits {

    static int getBit(int n, int index) {
        return (n >> index) & 1;
    }

    static int setBit(int n, int index) {
        return n | (1 << index);
    }

    static int resetBit (int n, int index) {
        return n & (~(1 << index));
    }

    private static int reverseBits (int n) {
        int left = 0, right = 31;

        while (left < right) {
            int leftBit = getBit(n, left);
            int rightBit = getBit(n, right);

            if (leftBit != rightBit) {
                if (leftBit == 1) {
                    n = setBit(n, right);
                    n = resetBit(n, left);
                } else {
                    n = setBit(n, left);
                    n = resetBit(n, right);
                }
            }
            left++;
            right--;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(6));
    }

}
