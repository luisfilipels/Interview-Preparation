public class RemoveConsecutiveCharacters {

    public String solve(String A, int B) {

        StringBuilder returnString = new StringBuilder();

        StringBuilder temp = new StringBuilder();
        for (char c : A.toCharArray()) {
            if (temp.length() == 0) {
                temp.append(c);
            } else {
                if (c == temp.charAt(temp.length()-1)) {
                    temp.append(c);
                } else {
                    if (temp.length() != B) {
                        returnString.append(temp);
                    }
                    temp = new StringBuilder();
                    temp.append(c);
                }
            }
        }
        if (temp.length() != B) {
            returnString.append(temp);
        }

        return returnString.toString();

    }

}
