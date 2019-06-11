public class C1Q1 {
    public static void main (String [] args) {
        String input = "abcdef";
        int[] conta = new int[26];
        for (int i = 0; i < input.length(); i++) {
            conta[input.charAt(i)-'a']++;
        }
        for (int i = 0; i < conta.length; i++) {
            if (conta[i] > 1) {
                System.out.println("Non-unique string!");
                return;
            }
        }
        System.out.println("Unique string!");
    }
}
