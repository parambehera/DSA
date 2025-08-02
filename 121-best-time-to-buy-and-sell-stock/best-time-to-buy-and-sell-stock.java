class Solution {
    public int maxProfit(int[] prices) {
        int minPrice =Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=1;i<prices.length;i++){
            minPrice = Math.min(minPrice,prices[i-1]);
            if(minPrice<prices[i]){
               maxProfit = Math.max(prices[i]-minPrice,maxProfit);
            }
        }
        return maxProfit;
    }
}