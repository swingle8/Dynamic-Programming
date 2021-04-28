//https://leetcode.com/problems/decode-ways/
class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (s.charAt(0) == '0')
            return 0;
        
        int [] ways = new int[len+1];
        ways[0] = 1;
        
        for (int i = 1 ; i <= len ; i++) {
            if (i == 1) {
                ways[i] = i;
                continue;
            }
            
            int noPairWays = 0;
            if (s.charAt(i-1) != '0')
                 noPairWays = ways[i-1];   
            String pair = String.valueOf(s.charAt(i-2)) + String.valueOf(s.charAt(i-1));
            int pairWays = 0;
            if (Integer.parseInt(pair) < 27 && Integer.parseInt(pair) > 9)
                  pairWays = ways[i-2];  
            ways[i] = noPairWays + pairWays;
        }
        
        return ways[len];
    }
}