import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static List<List<String>> partition (String s) {
        List<List<String>> returnList = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), returnList);
        return returnList;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    private static void helper (String s, int startIdx, List<String> currentList, List<List<String>> returnList) {
        if (startIdx >= s.length()) {
            returnList.add(new ArrayList<>(currentList));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = startIdx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String str = sb.toString();
            if (isPalindrome(str)) {
                currentList.add(str);
                helper(s, i + 1, currentList, returnList);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "abacoca";
        System.out.println(partition(s));
    }

}
