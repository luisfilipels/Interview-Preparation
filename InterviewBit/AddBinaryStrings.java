public class AddBinaryStrings {

    public String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();

        StringBuilder sbA = new StringBuilder(A);
        StringBuilder sbB = new StringBuilder(B);

        sbA = sbA.reverse();
        sbB = sbB.reverse();

        int carry = 0;
        int i;
        for (i = 0; i < Math.min(sbA.length(), sbB.length()); i++) {
            int res = ((sbA.charAt(i) - '0') + (sbB.charAt(i) - '0') + carry);
            result.append(res % 2);
            if (res >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        StringBuilder remain = sbA.length() > sbB.length() ? sbA : sbB;

        for (; i < remain.length(); i++) {
            int res = (remain.charAt(i) - '0') + carry;
            result.append(res % 2);
            if (res >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }
        }

        if (carry == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }

}
