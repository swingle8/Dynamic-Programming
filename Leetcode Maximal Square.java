class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int [][] dp = new int[rows+1][cols+1];
        int ans = 0;
        for (int i = 0 ; i <= rows ; i++) {
            for (int j = 0 ; j <= cols ; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
                    dp[i][j] = dp[i][j] + 1;
                }
                
                ans = Math.max (ans, dp[i][j]);
            }
        }
        
        return ans*ans;
    }
}