public class StringToInteger {

    /*

    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;


     */

    private static int getNum(char[] arr, int start, int sign) {
        int n = arr.length;
        int returnNum = 0;
        while (start < n && Character.isDigit(arr[start])) {
            /*
            To avoid integer overflow, we must ensure that it doesn't exceed this value. This condition needs to be handled
            when the result is greater than or equal to INT_MAX/10.
            - If returnNum == INT_MAX/10, it would result in overflow if next integer character is greater than 7 (the last
            digit of INT_MAX). We can use INT_MAX%10 to generically represent the last digit.
            - If result > INT_MAX/10, we are sure that adding next number would result in integer overflow
             */
            if (returnNum > Integer.MAX_VALUE / 10 || (returnNum == Integer.MAX_VALUE / 10 && arr[start] - '0' > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            returnNum = returnNum * 10 + (arr[start++] - '0');
        }
        return returnNum * sign;
    }

    private static int myAtoi(String str) {
        if (str.length() == 0) return 0;

        char [] chars = str.toCharArray();

        int i = 0;
        while (i < str.length() && chars[i] == ' ') {
            i++;
        }
        if (i == str.length()) return 0;

        int sign = 1;

        if (chars[i] == '-' || chars[i] == '+') {
            if (chars[i] == '-') sign = -1;
            i++;
            if (i == chars.length) return 0;
            if (!Character.isDigit(chars[i])) return 0;
            int num = getNum(chars, i, sign);
            return num;
        } else if (Character.isDigit(chars[i])) {
            return getNum(chars, i, 1);
        } else return 0;
    }

    public static void main(String[] args) {
        String str = "    10522545459";
        System.out.println(myAtoi(str));
    }

}
