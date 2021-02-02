public class ExcelColumnNumber {

    int charToInt (char c) {
        return c - 'A' + 1;
    }

    public int titleToNumber(String A) {
        int n = A.length();
        int result = 0;
        int power = 1;
        for (int i = n - 1; i >= 0; i--) {
            char current = A.charAt(i);

            result += charToInt(current) * power;
            power *= 26;
        }

        return result;
    }

}
