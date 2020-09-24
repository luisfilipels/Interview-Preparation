public class ExcelSheetColumnNumber {

    static int charToNumber (char c) {
        return c - 'A' + 1;
    }

    private static int titleToNumber (String s) {
        int returnValue = 0;
        int currentBase = 1;
        int n = s.length();
        for (int i = n-1; i >= 0; i--) {
            returnValue += currentBase * charToNumber(s.charAt(i));
            currentBase *= 26;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

}
