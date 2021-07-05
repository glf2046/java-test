package alg;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices3 = {100, 50, 100, 500, 300, 1000};
        System.out.println(maxProfitMultipleSell(prices3));
        System.out.println(maxProfitSellOnce(prices3));
    }

    private static int maxProfitMultipleSell(int[] prices) {

        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int buy = prices[0];
        System.out.println("new buy: " + buy);
        int sumProfit = 0;

        for (int i = 1; i < len; i++) {
            //如果当前价格<前一个价格，用之前的价格卖出，然后当前价格为新的买入价格
            if (prices[i] < prices[i - 1]) {
                sumProfit += prices[i - 1] - buy;
                System.out.println("new sell: " + prices[i-1]);
                buy = prices[i];
                System.out.println("new buy: " + prices[i]);
            } else {
                //如果是最后一个元素，而且当前价格>买的价格，那么卖出并累加利润
                if (i == len - 1) {
                    if (prices[i] > buy) {
                        sumProfit += prices[i] - buy;
                        System.out.println("new sell: " + prices[i]);
                    }
                }
            }
        }

        return sumProfit;
    }

    private static int maxProfitSellOnce(int[] prices) {
        int len = prices.length;
        if (len == 1) {
            return Integer.MIN_VALUE;
        }

        int buy = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i] < buy) {
                    buy = prices[i];
                }
            } else {
                int tempProfit = prices[i] - buy;
                if (tempProfit > maxProfit) {
                    maxProfit = tempProfit;
                }
            }
        }

        return maxProfit;
    }

    static class BuySell {
        public int buy;
        public int sell;
    }

    //n*n
    //do not find last sell point?
    private static int maxProfitMultipleSell(int[] prices, int n) {
        if (n == 1)
            return -1;

        int count = 0;
        BuySell[] sol = new BuySell[n / 2 + 1];

        int i = 0;
        while (i < n - 1) {
            while (prices[i + 1] <= prices[i])
                i++;
            if (i == n - 1)
                break;

            sol[count] = new BuySell();
            sol[count].buy = i++;

            while ((i < n) && prices[i] >= prices[i - 1])
                i++;
            sol[count].sell = i - 1;
            count++;
        }

        int maxProfit = 0;

        if (count > 0) {
            for (int j = 0; j < count; j++) {
                System.out.print("(" + sol[j].buy + ", " + sol[j].sell + ") ");
                maxProfit += prices[sol[j].sell] - prices[sol[j].buy];
            }
        }

        return maxProfit;
    }

    private static void maxProfit(int[] prices) {
        int buyIndex = -1, sellIndex = -1;
        int currentValue, nextValue;
        boolean buyIndexFound = false, sellIndexFound = false;
        for (int i = 0; i < prices.length - 1; i++) {
            currentValue = prices[i];
            nextValue = prices[i + 1];
            if (nextValue >= currentValue) {
                if (!buyIndexFound) {
                    buyIndex = i;
                    buyIndexFound = true;
                }

                if (i == prices.length - 2) {
                    sellIndexFound = true;
                    sellIndex = i + 1;
                }
            } else {
                if (buyIndexFound) {
                    sellIndex = i;
                    sellIndexFound = true;
                }
            }

            if (sellIndexFound) {
                System.out.print("(" + buyIndex + " " + sellIndex + ") ");
                buyIndexFound = false;
                sellIndexFound = false;
            }
        }
    }
}
