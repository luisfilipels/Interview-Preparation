public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);

        while (sbA.length() < sbB.length()) sbA.insert(0, '0');
        while (sbB.length() < sbA.length()) sbB.insert(0, '0');

        StringBuilder result = new StringBuilder();

        int carry = 0;

        int n = sbA.length();
        for (int i = n-1; i >= 0; i--) {
            int na = sbA.charAt(i) - '0';
            int nb = sbB.charAt(i) - '0';

            int sum = na + nb + carry;

            if (sum >= 2) carry = 1;
            else carry = 0;

            result.insert(0, Integer.toString(sum % 2));
        }

        if (carry == 1) {
            result.insert(0, '1');
        }

        return result.toString();

    }

}
