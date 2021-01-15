public class BreakAPalindrome {

    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int n = palindrome.length();

        StringBuilder sb = new StringBuilder();

        boolean changeMade = false;
        for (int i = 0; i < n; i++) {
            char c = palindrome.charAt(i);
            if (c != 'a' && !changeMade) {
                if (n % 2 == 1 && i == n/2) {
                    sb.append(c);
                    continue;
                }
                sb.append("a");
                changeMade = true;
            } else {
                sb.append(c);
            }
        }

        if (!changeMade) {
            boolean allAs = true;
            for (int i = (n / 2) + 1; i < n; i++) {
                if (sb.charAt(i) != 'a') {
                    allAs = false;
                    break;
                }
            }
            if (allAs) {
                sb.setCharAt(sb.length()-1, 'b');
            }

        }

        return sb.toString();
    }

}
