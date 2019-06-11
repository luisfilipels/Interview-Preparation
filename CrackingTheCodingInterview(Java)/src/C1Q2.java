public class C1Q2 {
    public static void main(String[] args) {
        String input1 = "abcdef";
        String input2 = "zzz";

        int [] conta = new int[26];

        for (int i = 0 ; i < input1.length(); i++) {
            conta[input1.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < input2.length(); i++) {
            conta[input2.charAt(i) - 'a'] -= 1;
        }
        for (int i : conta) {
            if (i != 0) {
                System.out.println("Not a permutation!");
                return;
            }
        }
        System.out.println("Permutation!");

    }
}
