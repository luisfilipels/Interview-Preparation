public class CountAndSay {

    private static String getString (String start) {
        StringBuilder sb = new StringBuilder();
        char [] arr = start.toCharArray();
        char current = '*';
        int countCurrent = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == current) {
                countCurrent++;
            } else {
                if (countCurrent != 0) {
                    sb.append(countCurrent).append(current);
                }
                current = arr[i];
                countCurrent = 1;
            }
        }
        if (countCurrent != 0) {
            sb.append(countCurrent).append(current);
        }

        return sb.toString();
    }

    private static String countAndSay(int n) {
        String [] memo = new String[n+1];
        memo[1] = "1";
        for (int i = 2; i <= n; i++) {
            memo[i] = getString(memo[i-1]);
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

}
