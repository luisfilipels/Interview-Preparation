public class RomanToInteger {

    static int romanToInt (char r) {
        switch (r) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }

    // This question is quite straightforward if you move from right to left in s.
    // Since we only have a few constraints related to what happens if we put some characters behind others, we can
    // verify if any character must have its value subtracted or added to the return value with a switch case, while
    // keeping track of what was the last character we checked.
    private static int romanToInt (String s) {
        int n = s.length();
        char lastChar = s.charAt(n-1);
        int returnInt = romanToInt(lastChar);
        for (int i = n-2; i >= 0; i--) {
            char currentChar = s.charAt(i);
            switch (currentChar) {
                case 'I':
                    if (lastChar == 'V' || lastChar == 'X') returnInt--;
                    else returnInt += romanToInt(currentChar);
                    break;
                case 'X':
                    if (lastChar == 'L' || lastChar == 'C') returnInt -= 10;
                    else returnInt += romanToInt(currentChar);
                    break;
                case 'C':
                    if (lastChar == 'D' || lastChar == 'M') returnInt -= 100;
                    else returnInt += romanToInt(currentChar);
                    break;
                default:
                    returnInt += romanToInt(currentChar);
            }
            lastChar = currentChar;
        }
        return returnInt;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
