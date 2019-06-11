public class C1Q3 {
    public static void main(String[] args) {
        char [] input = new char[]{'a', 'b', ' ', 'c', 'd', ' ', 'e', 'f', ' '};
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                char [] temp = new char[input.length + 2];
                int j;
                for (j = 0; j < i; j++) {
                    temp[j] = input[j];
                }
                temp[j++] = '%';
                temp[j++] = '2';
                temp[j++] = '0';
                for (; j < temp.length; j++) {
                    temp[j] = input[j - 2];
                }
                input = temp;
            }
        }
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]);
        }
    }
}
