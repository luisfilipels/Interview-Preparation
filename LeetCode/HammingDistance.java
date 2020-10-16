public class HammingDistance {

    private static int hammingDistance(int x, int y) {
        int distance = 0;

        for (int i = 0; i < 32; i++) {
            distance += (((x >> i) & 1) ^ ((y >> i) & 1));
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

}
