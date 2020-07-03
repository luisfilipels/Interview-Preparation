package Extras.HackerRank;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int altitude = 0;
        boolean isInValley = false;
        char [] array = s.toCharArray();
        int valleyCount = 0;
        for (char c : array) {
            if (c == 'D') {
                altitude--;
                if (altitude < 0 && !isInValley) {
                    isInValley = true;
                    valleyCount++;
                }
            } else if (c == 'U') {
                altitude++;
                if (altitude >= 0 && isInValley) {
                    isInValley = false;
                }
            }
        }
        return valleyCount;

    }

    public static void main(String[] args) {
        String string = "DDUUDDUDUUUD";
        int size = string.length();
        System.out.println(countingValleys(size, string));

    }

}
