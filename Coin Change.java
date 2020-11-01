//https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int [amount+1];
        dp[0] = 0;
        for (int i = 1 ; i < amount+1 ; i++)
            dp[i] = amount+1;
        
        for (int i = 1 ; i < amount+1 ; i ++) {
            for (int k = 0 ; k < coins.length ; k++) {
                if (coins[k] <= i && dp[i - coins[k]] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[k]] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}