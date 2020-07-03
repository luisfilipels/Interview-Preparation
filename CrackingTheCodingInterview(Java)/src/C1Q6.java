public class C1Q6 {

    static String compress (String input) {
        StringBuilder sb = new StringBuilder();

        int currentCount = 0;
        Character compressChar = null;
        for (char current : input.toCharArray()) {
            if (compressChar == null) {
                compressChar = current;
            }
            if (compressChar != current) {
                sb.append(compressChar).append(currentCount);
                currentCount = 1;
                compressChar = current;
            } else {
                currentCount++;
            }
        }
        sb.append(compressChar).append(currentCount);
        return sb.length() < input.length() ? sb.toString() : input;
    }

    public static void main(String[] args) {
        String input = "aaaab";
        System.out.println(compress(input));
    }
}
