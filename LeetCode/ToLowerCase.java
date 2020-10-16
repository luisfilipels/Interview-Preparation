import java.util.HashMap;

public class ToLowerCase {

    private static String toLowerCase(String str) {
        char [] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 'Z' && arr[i] >= 'A') {
                arr[i] += 'a' - 'A';
            }
        }
        return String.copyValueOf(arr);
    }

    private static String toLowerCase2 (String str) {
        HashMap<Character, Character> hash = new HashMap<>();

        char toMap = 'A';
        for (char c = 'a'; c <= 'z'; c++) {
            hash.put(toMap++, c);
        }

        char [] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 'Z' && arr[i] >= 'A') {
                arr[i] = hash.get(arr[i]);
            }
        }

        return String.copyValueOf(arr);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }

}
