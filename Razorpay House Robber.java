class Solution {
    public int rob(int[] nums) {
        int [] valAfterDecision = new int[nums.length];
        valAfterDecision[0] = nums[0];
        int ans = valAfterDecision[0];
        for (int i = 1 ; i < nums.length ; i++) {
            int no = valAfterDecision[i-1];
            int yes = 0;
            if (i - 2 >= 0)
                yes = valAfterDecision[i-2];
            yes += nums[i];
            valAfterDecision[i] = Math.max(yes, no);
            ans = Math.max(ans, valAfterDecision[i]);
        }
        
        return ans;
    }
}