public class FindComplement {

    static int findMask(int num) {
        int i = 1;
        int count = 0;
        while (count < num) {
            i *= 2;
            count = i-1;
        }
        return i-1;
    }

    private static int findComplement(int num) {
        int mask = findMask(num);

        int comp = 0;
        for (int i = 0; i < 32; i++) {
            int bit = ((num >> i) & 1);
            int notBit = bit == 1 ? 0 : 1;
            comp += (notBit << i);
        }
        return comp & mask;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(4));
    }


}
