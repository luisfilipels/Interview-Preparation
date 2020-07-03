package Extras.LeetCode;

public class BestTimeToBuySellStockCooldown {


    // New solution. Perhaps easier to understand.
    /*
    Consider the following instance of prices:

    prices = [1, 2, 3, 0, 2]

    In the execution of this algorithm, we have to consider three states: we can buy, we can sell, and rest. Let's create
    three arrays, each representing the profit we have by either buying, selling or resting.

    buy = []
    sell = []
    rest = []

    If we buy at the 0th day, what's our profit? It's -prices[0]:

    buy = [-1]

    We cannot sell at the first day, we can only buy or rest, so:

    buy = [-1]
    sell = [0]
    rest = [0]

    Back to the buy array, we can consider that at day i we can either not buy at the current price (which means buy[i-1]
    is passed over to buy[i]), or we can buy (which means our profit from buying will come over from rest[i-1], minus the
    price at the current day). Let's get the maximum of these two numbers.

    buy = [-1, -1]

    In the sell array, for every day i, we can either not sell (which carries over the result of the previous day), or,
    we can sell at the current price (which means summing our profit from buy[i-1] + price[i]). We once again choose whichever
    yields the most profit.

    sell = [0, 1]

    Finally, if we rest, that means we just sold (which brings over the profit from sell[i-1]), or keep on resting (which
    brings in the profit from resting in the previous day). Choose whichever brings the most profit.

    rest = [0, 0]

    Finally, we certainly won't yield any profit from buying at the last day, so we choose the maximum from selling at the
    last day or from resting.

     */
    private static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int [] buy = new int[n];
        int [] sell = new int[n];
        int [] rest = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i-1], rest[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            rest[i] = Math.max(sell[i-1], rest[i-1]);
        }

        return Math.max(sell[n-1], rest[n-1]);
    }

    // Old solution
    /*static public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int n = prices.length;
        int [] canBuyOrRestState = new int[n]; // can buy or rest
        int [] canSellOrRestState = new int[n]; // can sell or rest
        int [] restState = new int[n]; // can only rest (just sold)

        canBuyOrRestState[0] = 0; // At the start, you don't have any stock if you just rest
        canSellOrRestState[0] = -prices[0]; // After buy, you should have -prices[0] profit.
        restState[0] = Integer.MIN_VALUE; // Lower base case

        for (int i = 1; i < n; i++) {
            canBuyOrRestState[i] = Math.max(canBuyOrRestState[i-1], restState[i-1]);    // Can reach current state from either a previous buy state (I skipped buying) or from leaving the cooldown
            canSellOrRestState[i] = Math.max(canSellOrRestState[i-1], canBuyOrRestState[i-1] - prices[i]); // Can reach the sell state from skipping on selling or from buying
            restState[i] = canSellOrRestState[i-1] + prices[i]; // Can reach the cooldown state from selling (increases profit by adding prices[i])
        }
        return Math.max(canBuyOrRestState[n-1], restState[n-1]);
    }*/

    public static void main(String[] args) {
        int [] prices = new int[] {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

}
