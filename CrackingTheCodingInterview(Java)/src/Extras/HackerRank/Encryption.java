package Extras.HackerRank;

public class Encryption {

    // No need to actually build an array on this one.

    static String encryption(String s) {
        StringBuilder sb = new StringBuilder();

        int l = s.length();

        double sqrt = Math.sqrt(l);

        int rows = (int)Math.ceil(sqrt);
        int cols;
        if (rows >= (int) sqrt) {
            cols = rows;
        } else {
            cols = rows+1;
        }

        for (int col = 0; col < cols; col++) {
            for (int row = col; row < l; row += cols) {
                sb.append(s.charAt(row));
            }
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "feedthedog";
        System.out.println(encryption(input));
    }

}
