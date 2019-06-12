public class C1Q5 {

    public static boolean oneAway(String input1, String input2) {
        if (input1.length() == input2.length()) {
            int errorCount = 0;
            for (int i = 0; i < input1.length(); i++) {
                if (input1.charAt(i) != input2.charAt(i)) {
                    errorCount++;
                    if (errorCount > 1) {
                        return false;
                    }
                }
            }
            return true;
        } else if (Math.abs(input1.length() - input2.length()) == 1){
            String maior, menor;
            maior = input1.length() > input2.length() ? input1 : input2;
            menor = maior.equals(input1) ? input2 : input1;
            boolean errorFound = false;
            for (int i = 0; i < maior.length(); i++) {
                if (i != menor.length() && !errorFound && maior.charAt(i) != menor.charAt(i)) {
                    errorFound = true;
                    continue;
                }
                if (errorFound && maior.charAt(i) != menor.charAt(i-1)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(oneAway("pale", "ple"));
    }
}
