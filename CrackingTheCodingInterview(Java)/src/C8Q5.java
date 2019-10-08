public class C8Q5 {

    static int [] dp;       // No need for it to be 2D, as big never changes. We only store the corresponding value to some sml value
    static boolean dpCreated = false;

    static int multiply (int num1, int num2) {
        int big = num1 < num2 ? num2 : num1;
        int sml = num1 < num2 ? num1 : num2;
        if (!dpCreated) {
            dp = new int[sml + 1];
            dpCreated = true;
        }
        return auxMultiply(sml, big);
    }

    static int auxMultiply (int sml, int big) {
        if (sml == 0) {
            return 0;
        } else if (sml == 1) {          // 1 column, 'big' lines long
            return big;
        } else if (dp[sml] > 0) {
            return dp[sml];
        }
        int sml2 = sml >> 1; // Divide by 2
        int side1 = multiply(sml2, big);        // Recursively divide until we reach 1 column of width (or, a value already in dp[])
        int side2;
        if (sml % 2 == 1) {
            side2 = auxMultiply(sml - sml2, big);           // If uneven, recalculate
        } else {
            side2 = side1;                                       // Else, just reuse the value of side1
        }
        dp[sml] = side1 + side2;
        return dp[sml];

    }

    /*
    // Book approach, no DP
    static int multiply (int num1, int num2) {
        int big = num1 < num2 ? num2 : num1;
        int sml = num1 < num2 ? num1 : num2;
        return auxMultiply(sml, big);
    }

    static int auxMultiply (int sml, int big) {
        if (sml == 0) {
            return 0;
        } else if (sml == 1) {          // 1 column, big lines long
            return big;
        }
        int sml2 = sml >> 1; // Divide by 2
        int side1 = multiply(sml2, big);
        int side2;
        if (sml % 2 == 1) {
            side2 = auxMultiply(sml - sml2, big);           // If uneven, recalculate
        } else {
            side2 = side1;                                       // Else, just reuse the value of side1
        }
        return side1 + side2;

    }

    */

    /*
    // Probably a naive, linear solution
    static int multiply (int num1, int num2) {
        if (num2 > num1) {
            int aux = num1;
            num1 = num2;
            num2 = aux;
        }
        return auxMultiply (num1, num2, num1);
    }

    static private int auxMultiply(int num1, int num2, int orig) {
        if (num2 == 0) {
            return 0;
        }
        if (num2 == 1) {
            return num1;
        } else if (num1 == 1) {
            return num2;
        }
        num1 += orig;
        return auxMultiply(num1, num2 - 1, orig);
    }
    */

    public static void main(String[] args) {
        System.out.println(multiply(3, 17));
    }
}
