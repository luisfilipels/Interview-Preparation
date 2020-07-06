public class C1Q3 {

    static char[] URLify (char[] input) {

        int left = input.length-1;
        while (input[left] == ' ') {
            left--;
        }

        int count = 0;
        for (int i = 0; i < left; i++) {
            if (input[i] == ' ') count++;
        }

        System.out.println(count);
        int right = left + 2 * count;

        int limit = 0;
        while (limit < input.length && input[limit] != ' ') {
            limit++;
        }
        while (left >= 0 && left != limit-1) {
            while (left >= 0 && input[left] != ' ') {
                input[right--] = input[left--];
            }
            input[right--] = '0';
            input[right--] = '2';
            input[right--] = '%';
            left--;
        }
        return input;
    }

    public static void main(String[] args) {
        String input = "Mr   John Smith abc                                                   ";
        //String input = "Mr Smith  ";
        System.out.println(URLify(input.toCharArray()));
    }
}
