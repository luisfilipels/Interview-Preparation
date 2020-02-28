package Extras.LeetCode;

public class OneEditDistance {

    static boolean oneEdit (String s, String p) {
        // Find lengths of given strings
        int m = s.length(), n = p.length();

        // If difference between lengths is
        // more than 1, then strings can't  
        // be at one distance
        if (Math.abs(m - n) > 1)
            return false;

        int count = 0; // Count of edits

        int i = 0, j = 0;
        while (i < m && j < n)
        {
            // If current characters don't match
            if (s.charAt(i) != p.charAt(j))
            {
                if (count == 1)
                    return false;

                // If length of one string is
                // more, then only possible edit
                // is to remove a character
                if (m > n)
                    i++;
                else if (m< n)
                    j++;
                else // Iflengths of both strings
                // is same
                {
                    i++;
                    j++;
                }

                // Increment count of edits
                count++;
            }

            else // If current characters match
            {
                i++;
                j++;
            }
        }

        // If last character is extra
        // in any string
        if (i < m || j < n)
            count++;

        return count == 1;
    }



    /*
    // Recursive solutions. Both pass, but use extra space.

    static boolean oneEdit (String s, String p) {
        if (Math.abs(s.length() - p.length()) > 1) {
            return false;
        }
        return oneEdit(s, p, 0, 0, false);
    }

    static boolean oneEdit (String s, String p, boolean editMade) {

        if (s.length() == 0 && p.length() == 0) {
            return editMade;
        } else if ((s.length() == 0 && p.length() == 1) || (p.length() == 0 && s.length() == 1)) {
            return !editMade;
        }
        if (s.charAt(0) == p.charAt(0)) {
            return oneEdit(s.substring(1), p.substring(1), editMade);
        } else {
            if (s.length() == p.length()) {
                if (editMade) return false;
                return oneEdit(s.substring(1), p.substring(1), true);
            } else {
                String larger = s.length() > p.length() ? s : p;
                String smaller = larger.equals(s) ? p : s;
                return oneEdit(larger.substring(2), smaller.substring(1), true);
            }
        }
    }

    static boolean oneEdit (String s, String p, int i, int j, boolean editMade) {

        if (s.length() - i == 0 && p.length() - j == 0) {
            return editMade;
        } else if ((s.length() - i == 0 && p.length() - j == 1) || (p.length() - j == 0 && s.length() - i == 1)) {
            return !editMade;
        }

        if (s.charAt(i) == p.charAt(j)) {
            return oneEdit(s, p, i+1, j+1, editMade);
        } else {
            if (s.length() - i == p.length() - j) {
                if (editMade) return false;
                return oneEdit(s, p, i+1, j+1, true);
            } else {
                if (s.length() < p.length()) {
                    String swap = p;
                    p = s;
                    s = swap;
                }
                return oneEdit(s, p, i + 2, j + 1, true);
            }
        }
    }
    */
    public static void main(String[] args) {
        String s = "bcde";
        String p = "abcde";

        System.out.println(oneEdit(s, p));
    }

}
