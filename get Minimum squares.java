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
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.MinSquares(n);
            System.out.println(ans);           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int count = Integer.MAX_VALUE;
    public int MinSquares(int n) {
        
        int maxLimit = (int) Math.sqrt(n);
        //getCount (n, maxLimit, 0);
        
        
        return count;
    }
    
    public void getCount (int n, int current, int ans) {
        if (n == 0) {
           count = Math.min(ans, count);
           return;
        }
        
        for (int i = current ; i > 0 ; i--) {
            int mul = i*i;
            if (n >= mul) {
                int divide = n/mul;
                n = n - (mul*divide);
                ans += divide;
                getCount (n, i-1, ans);
                ans -= divide;
                n = n + mul*divide;
            }
        }
    }
}