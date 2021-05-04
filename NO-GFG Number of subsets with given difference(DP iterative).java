int countSubSets (int [] arr, int N, int diff) {
    int sum = 0;
    for (int i = 0 ; i < N ; i++)
        sum += arr[i];    
    boolean [][] dp = new boolean[arr.length+1][sum+1];

    for (int i = 0 ; i <= arr.length ; i++) {
        for (int j = 0 ; j <= sum ; j++) {
            if (j == 0)
                dp[i][j] = true;
            else if (i == 0)
                dp[i][j] = false;
            else if (j < arr[i-1])
                dp[i][j] = dp[i-1][j];
            else
                dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
        }
    }
    int ans = 0;
    for (int j = sum ; j >= 0 ; j--) {
        if (dp[arr.length][j]) {
            int val = sum - j;
            if (Math.abs(val-j) == diff)
                ans++;
        }
    }

    return ans;
    
}
