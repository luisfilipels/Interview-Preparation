package Extras.HackerRank;

public class RecursiveDigitSum {

    static int superDigit (String n, int k) {
        long first = divideAndConquer(n) * k;
        while (first >= 10) {
            first = divideAndConquer(Long.toString(first));
        }
        return (int) first;
    }

    static long divideAndConquer (String n) {
        if (n.length() == 1) {
            return n.charAt(0) - '0';
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        char [] ca = n.toCharArray();

        for (int i = 0; i < ca.length/2; i++) {
            left.append(ca[i]);
        }
        for (int i = ca.length/2; i < ca.length; i++) {
            right.append(ca[i]);
        }
        long lLeft = divideAndConquer(left.toString());
        long lRight = divideAndConquer(right.toString());

        return lLeft + lRight;
    }

    public static void main(String[] args) {
        System.out.println(superDigit("3546630947312051453014172159647935984478824945973141333062252613718025688716704470547449723886626736", 100000));
    }

}
