package Extras.LeetCode;

public class BestTimeToBuySellStock {

    // Shorter answer
    static private int maxProfit (int [] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    /*static private int maxProfit (int [] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minBuy) {
                minBuy = prices[i];
            } else if (prices[i] - minBuy > maxProfit) {
                maxProfit = prices[i] - minBuy;
            }
        }
        return maxProfit;
    }*/

    // Solução força bruta, quadrática
    /*static private int maxProfit (int [] prices) {
        int n = prices.length;
        int max = 0;
        for (int l = 0; l < n; l++) {
            for (int c = l; c < n; c++) {
                max = Math.max(max, prices[c] - prices[l]);
            }
        }
        return max;
    }*/

    public static void main(String[] args) {
        int [] prices = new int[] {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

}
