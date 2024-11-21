package arrayAndHashing;

class SolutionBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        var minPrice = prices[0];
        var maxProfit = 0;

        for(int price : prices){
            var sellingToday = price - minPrice;
            maxProfit = Math.max(maxProfit, sellingToday);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        var maxProfit = maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit);
    }
}