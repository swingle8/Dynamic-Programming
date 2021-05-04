class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return getWays (coins, n-1, amount);
    }
    
    //brute-force
    public int getWays (int [] coins, int n, int amount) {
        if (amount == 0)
            return 1;
            
        if (n < 0)
            return 0;
            
        if (amount < coins[n])
                return getWays (coins, n-1, amount);
        return getWays(coins, n, amount-coins[n]) + getWays (coins, n-1, amount);
    }
}