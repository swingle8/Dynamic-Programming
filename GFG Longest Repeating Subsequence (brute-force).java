// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int len = str.length();
        return lrs (str, str, len-1, len-1);
    }
    
    public int lrs (String s1, String s2, int x, int y) {
        if (x < 0 || y < 0)
            return 0;
        
        if (x != y && s1.charAt(x) == s2.charAt(y))
            return 1 + lrs (s1, s2, x-1, y-1);
        
        return Math.max (lrs (s1, s2, x, y-1), lrs (s1, s2, x-1, y));
    }
}