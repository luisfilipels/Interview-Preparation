public class NumberOfOneBits {

    private static int hammingWeight (int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1 )== 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-3));
    }

}
