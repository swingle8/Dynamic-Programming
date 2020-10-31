//https://leetcode.com/problems/perfect-squares/submissions/
class Solution {
    public int numSquares(int n) {
        int ans = Integer.MAX_VALUE;
        int start = (int) Math.sqrt(n);
        for (int  i = start ; i > 0 ; i--) {
            int curr = i*i;
            if (n < curr)
                continue;
            int times = n/curr;
            
            int diff = n - curr*times;
            if (diff > 0 && times < ans)
                times = times + numSquares (diff);
            
            ans = Math.min(ans, times);
        }
        
        return ans;
        
    }
}