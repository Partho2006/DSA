// 121. Best Time to Buy and Sell Stock
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}

// Best Time to Buy and Sell Stock – Simple Text Explanation

// Goal: Buy one day and sell later to get maximum profit.

// Step 1:
// Set buy as the first price.
// Set profit = 0.

// Step 2: Go through the array from second element to last.

// For each price:
// If current price is less than buy, update buy (found cheaper price).
// Otherwise, calculate profit = current price − buy.
// If this profit is greater than previous profit, update profit.

// Step 3: Return profit.


// Time complexity: O(n)
// Space complexity: O(1)