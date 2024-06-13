/*
	https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	Best Time to Buy and Sell Stock - LeetCode #121 Easy
	
	Say you have an array for which the ith element is the price of a given stock 
	on day i.

	If you were only permitted to complete at most one transaction (i.e., buy 
	one and sell one share of the stock), design an algorithm to find the maximum 
	profit.

	Note that you cannot sell a stock before you buy one.

	Example 1:
		Input: [7,1,5,3,6,4]
		Output: 5
		Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
					 Not 7-1 = 6, as selling price needs to be larger than buying price.
	
	Example 2:
		Input: [7,6,4,3,1]
		Output: 0
		Explanation: In this case, no transaction is done, i.e. max profit = 0.

	Test case:
	[6,7,1,5,3,6]
*/

public class BestTimeToBuySellStock1_LC121 {
	public static void main(String[] args) {
		//int[] stockPrices = {7,1,5,3,6,4};
		int[] stockPrices = {7,6,4,3,1};
		
		System.out.println("Profit is " + maxProfit(stockPrices));
	}
	public static int maxProfit(int[] prices) {
		int maxIndex = prices.length - 1, minIndex = 0, profit = 0;
		
		
		while ( maxIndex > minIndex) {
			if (prices[minIndex] > prices[maxIndex]) {
				minIndex++;
			} else {
				if (profit < prices[maxIndex] - prices[minIndex]) {
					profit = prices[maxIndex] - prices[minIndex];
				}
				maxIndex--;
			}
			//System.out.println("Max:" + maxIndex + " Min:" + minIndex + " profit:" + profit);
		}		
		
        return profit;
    }
}
