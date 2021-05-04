class Solution {
    public int minOperations(int[] nums, int x) {
        int i = 0;
        int j = nums.length-1;
        int ans = getMinRemovals (nums, x, i, j);
        if (ans >= 100000000)
            return -1;
        return ans;
    }
    
    public int getMinRemovals (int [] nums, int x, int i, int j) {
        if (x == 0)
            return 0;
        if (i > j)
            return 100000000;
        
        return Math.min (1 + getMinRemovals (nums, x-nums[i], i+1, j), 1 + getMinRemovals (nums, x-nums[j], i, j-1));
    }
}