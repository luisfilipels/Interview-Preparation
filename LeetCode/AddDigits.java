public class AddDigits {

    private static int addDigits(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    private static int addDigits2 (int num) {
        int mod = num % 9;
        if (mod == 0) return 9;
        else return mod;
    }

    public static void main(String[] args) {
        for (int i = 10; i <= 200; i++) {
            System.out.println(i + " " + addDigits(i));
        }
    }

}
