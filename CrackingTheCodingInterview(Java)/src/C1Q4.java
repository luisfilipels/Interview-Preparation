public class C1Q4 {
    public static void main(String[] args) {
        String input = "oaawoo";
        int []conta = new int[26];
        int contaImpar = 0;
        input = input.replaceAll("\\s+", "");
        for (int i = 0; i < input.length(); i++) {
            conta[Character.toLowerCase(input.charAt(i)) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (!(conta[i] % 2 == 0) ) {
                contaImpar++;
            }
            if (contaImpar > 1) {
                System.out.println("False!");
                return;
            }
        }
        System.out.println("True!");
    }
}
