public class LongestCommonPrefix {

    private static String longestCommonPrefix (String [] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            Character current = null;
            for (String str : strs) {
                if (str.length() == 0) return "";
                if (i >= str.length()) return sb.toString();
                if (current == null) {
                    current = str.charAt(i);
                } else {
                    if (str.charAt(i) != current) {
                        return sb.toString();
                    }
                }
            }
            i++;
            sb.append(current);
        }
    }

    public static void main(String[] args) {
        String [] strs = new String[] {
                "flower", "flower", "flower", "flower"
        };
        System.out.println(longestCommonPrefix(strs));
    }

}
