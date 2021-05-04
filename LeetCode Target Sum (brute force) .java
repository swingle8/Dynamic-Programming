class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        return getCount (nums, target, n-1, sum);
    }
    
    public int getCount (int [] nums, int target, int i, int sum) {
        if (i < 0) {
            if (sum == target)
                return 1;
            return 0;
        }
        
        return getCount (nums, target, i-1, sum+nums[i]) + getCount (nums, target, i-1, sum-nums[i]);
    }
}