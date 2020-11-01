//https://leetcode.com/problems/unique-paths/
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for (int i = 1 ; i <= m ; i++) {
            for (int j = 1 ; j <= n ; j ++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}

//the below code for the above problem saves O(n) space
class Solution {
    public int uniquePaths(int m, int n) {
        int [] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 1 ; i <= m ; i++) {
            for (int j = 1 ; j <= n ; j ++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n];
    }
}
