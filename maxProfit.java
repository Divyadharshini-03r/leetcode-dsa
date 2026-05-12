public class maxProfit {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {

                maxProfit = maxProfit + prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        maxProfit obj = new maxProfit();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = obj.maxProfit(prices);

        System.out.println(result);
    }
}