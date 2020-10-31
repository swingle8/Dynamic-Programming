//https://leetcode.com/problems/house-robber/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int [] robberyTillHere = new int [n+1];
        robberyTillHere[0] = 0;
        robberyTillHere[1] = nums[0];
        int ans = robberyTillHere[1] ;
        
        for (int i = 2 ; i < n+1 ; i ++) {
            int valueRobCurrent = nums[i-1] + robberyTillHere[i-2];
            int valueNotRobCurrent = robberyTillHere[i-1];
            robberyTillHere[i] = Math.max(valueRobCurrent, valueNotRobCurrent);
            
            ans = Math.max(ans, robberyTillHere[i]);
        }
        return ans;
    }
}