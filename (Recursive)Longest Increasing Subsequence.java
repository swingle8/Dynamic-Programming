//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    int ans = 1;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        
        ans = 1;
        int [] LingestIncreasingSubsequenceTillHere = new int [n];
        LingestIncreasingSubsequenceTillHere[0] = 1;
        longestLength (nums, 1, LingestIncreasingSubsequenceTillHere, n);
        return ans;
    }
    
    public void longestLength (int [] nums, int i, int [] LingestIncreasingSubsequenceTillHere, int n) {
        if (i >= n)
            return;
        
        LingestIncreasingSubsequenceTillHere[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (nums[j] < nums[i])
                    LingestIncreasingSubsequenceTillHere[i] = Math.max (LingestIncreasingSubsequenceTillHere[j] + 1, LingestIncreasingSubsequenceTillHere[i]);

            }
            
        ans = Math.max (LingestIncreasingSubsequenceTillHere[i], ans);
        longestLength (nums, ++i, LingestIncreasingSubsequenceTillHere, n);
    }
}