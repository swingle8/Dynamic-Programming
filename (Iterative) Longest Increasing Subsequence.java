//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        
        int ans = 1;
        int [] LingestIncreasingSubsequenceTillHere = new int [n];
        LingestIncreasingSubsequenceTillHere[0] = 1;
        for (int i = 1; i < n ; i ++) {
            LingestIncreasingSubsequenceTillHere[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i]) {
                    LingestIncreasingSubsequenceTillHere[i] = Math.max (LingestIncreasingSubsequenceTillHere[j] + 1, LingestIncreasingSubsequenceTillHere[i]);
                }
            }
            if (ans < LingestIncreasingSubsequenceTillHere[i])
                ans = LingestIncreasingSubsequenceTillHere[i];
        }
        
        return ans;
    }
}