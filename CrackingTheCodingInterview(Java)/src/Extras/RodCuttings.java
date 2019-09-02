package Extras;

public class RodCuttings {

    static int cutRod(int n, int [] priceArray) {
        if (n <= 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, priceArray[i] + cutRod(n - i - 1, priceArray));
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 3;
        int [] priceArray = {1, 5, 8, 9, 10, 17, 20, 24, 30};
        System.out.println(cutRod(n,priceArray));
    }

}
