package Extras.LeetCode;

public class MaxProfitWithCooldown {

    private static int maxProfit (int [] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int [] canBuyOrRestState = new int[n]; // can buy or rest
        int [] canSellOrRestState = new int[n]; // can sell or rest
        int [] justSoldState = new int[n]; // can only rest (just sold)

        canBuyOrRestState[0] = 0; // At the start, you don't have any stock if you just rest
        canSellOrRestState[0] = -prices[0]; // After buy, you should have -prices[0] profit.
        justSoldState[0] = Integer.MIN_VALUE; // Lower base case

        for (int i = 1; i < n; i++) {
            canBuyOrRestState[i] = Math.max(canBuyOrRestState[i-1], justSoldState[i-1]);    // Can reach current state from either a previous buy state (I skipped buying) or from leaving the cooldown
            canSellOrRestState[i] = Math.max(canSellOrRestState[i-1], canBuyOrRestState[i-1] - prices[i]); // Can reach the sell state from skipping on selling or from buying
            justSoldState[i] = canSellOrRestState[i-1] + prices[i]; // Can reach the cooldown state from selling (increases profit by adding prices[i])
        }
        return Math.max(canBuyOrRestState[n-1], justSoldState[n-1]);
    }

    /*private static int maxProfit (int[] prices) {
        int [] dp = new int[prices.length];
        return helper(prices, false, false, 0, 0, 0);
    }*/

    /*private static int helper (int [] prices, boolean hasSold, boolean hasBought, int pos, int boughtSum, int currentProfit) {
        if (pos >= prices.length) return currentProfit;
        if (hasSold) {
            return helper(prices, false, false, pos+1, 0, currentProfit);
        } else {
            if (hasBought) {
                if (prices[pos] > boughtSum) {
                    int willSell = helper(prices, true, false,pos+1, 0, currentProfit + prices[pos] - boughtSum);
                    int willNotSell = helper(prices, false, true, pos+1, boughtSum, currentProfit);
                    return Math.max(willSell, willNotSell);
                } else {
                    return helper(prices, false, true, pos+1, boughtSum, currentProfit);
                }
            } else {
                int willBuy = helper(prices, false, true, pos+1, prices[pos], currentProfit);
                int willNotBuy = helper(prices, false, false ,pos+1, 0, currentProfit);
                return Math.max(willBuy, willNotBuy);
            }
        }

    }*/

    public static void main(String[] args) {
        int [] prices = new int[] {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

}
